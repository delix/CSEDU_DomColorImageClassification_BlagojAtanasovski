package edu.fcse.domcolorclassifier.algorithms;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;

import edu.fcse.domcolorclassifier.ImgData;
import edu.fcse.domcolorclassifier.MethodToApply;
import edu.fcse.domcolorclassifier.colorutils.CustColor;
import edu.fcse.domcolorclassifier.functions.distance.DistanceFunction;
import edu.fcse.domcolorclassifier.functions.weight.WeightFunction;

/**
 * extendsion to AddToMultipleCenters algorithm, checks to see if a pixel's
 * color is within a certain radius of a grav. center if yes it is valued,
 * otherwise discarded
 * 
 * @author Blagoj Atansovski
 * 
 */
public class AddToMultipleCentersMaxDistAlgorithm implements AlgorithmToApply {

	@Override
	public String classifyImage(BufferedImage imageToClassify,
			MethodToApply method, List<CustColor> gravityCenters,
			boolean fixedValue) {
		if (imageToClassify == null) {
			return "";
		}
		HashMap<CustColor, Double> colorAppearance = new HashMap<>();
		for (CustColor cc : gravityCenters) {
			colorAppearance.put(cc, 0.0);
		}

		ImgData imgData = new ImgData(imageToClassify);
		DistanceFunction distanceF = method.getDistanceFunction();
		WeightFunction weiF = method.getWeightFunction();
		float[][][] pixels = method.getSmooth().smooth(imgData.getRgbdata());
		float[][][] pixelsD = method.convertToColorSpace(pixels);
		int width = imageToClassify.getWidth();
		int height = imageToClassify.getHeight();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {

				double weight = weiF.getWeight(i, j, height / 2, width / 2);
				for (int k = 0; k < gravityCenters.size(); k++) {
					CustColor curr = gravityCenters.get(k);
					float[] valuesCurr = curr.getValues();
					double currDistance = distanceF.getDistance(valuesCurr,
							pixelsD[i][j]);
					
					if (currDistance <= method.getDiscardDistance()) {
						//System.out.println("unatre");
						double R = 1 / currDistance;//TODO: proveri so znaci ovoa dali imam dvojno delenje t.e. delenje so nula koma neso 
						colorAppearance.put(curr, colorAppearance.get(curr)
								+ weight * R);
					}
				}

			}
		}

		CustColor max = gravityCenters.get(0);
		System.out.println(colorAppearance.toString());
		double maxAppearence = colorAppearance.get(max);
		for (CustColor cc : colorAppearance.keySet()) {
			if (colorAppearance.get(cc) > maxAppearence) {
				max = cc;
				maxAppearence = colorAppearance.get(cc);
			}
		}
		return max.getName();
	}

}
