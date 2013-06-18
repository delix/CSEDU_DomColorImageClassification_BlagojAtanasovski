package edu.fcse.domcolorclassifier.gui;

import edu.fcse.domcolorclassifier.ClassificationResultWithVisualization;
import edu.fcse.domcolorclassifier.MethodToApply;
import edu.fcse.domcolorclassifier.algorithms.AddToMultipleCentersAlgorithm;
import edu.fcse.domcolorclassifier.algorithms.AlgorithmToApply;
import edu.fcse.domcolorclassifier.algorithms.visualization.AlgorithmToApplyWithVisualization;
import edu.fcse.domcolorclassifier.algorithms.BasicAlgorithm;
import edu.fcse.domcolorclassifier.algorithms.BasicWithDiscardDistanceAlgorithm;
import edu.fcse.domcolorclassifier.algorithms.EqDistCountDoubleAlgorithm;
import edu.fcse.domcolorclassifier.algorithms.visualization.AddToMultipleCentersAlgorithmVIZ;
import edu.fcse.domcolorclassifier.algorithms.visualization.AddToMultipleCentersMaxDistAlgorithmVIZ;
import edu.fcse.domcolorclassifier.algorithms.visualization.BasicAlgorithmVIZ;
import edu.fcse.domcolorclassifier.algorithms.visualization.BasicWithDiscardDistanceAlgorithmVIZ;
import edu.fcse.domcolorclassifier.algorithms.visualization.EqDistCountDoubleAlgorithmVIZ;
import edu.fcse.domcolorclassifier.colorutils.CustColor;
import edu.fcse.domcolorclassifier.gui.custcomponents.ImageTools;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Blagoj Atanasovski
 */
public class VisualizationHelper {

    private final int THUMB_HEIGHT = 130;
    private static VisualizationHelper instance;
    private BufferedImage originalFile;
    private Map<CustColor, BufferedImage> colloredForCenter;
    private BufferedImage[] thumbs;
    private String originalFilename;
    private List<CustColor> gravCenters;
    private AlgorithmToApplyWithVisualization algo;

    public BufferedImage getOriginalFile() {
        return originalFile;
    }

    public Map<CustColor, BufferedImage> getColloredForCenter() {
        return colloredForCenter;
    }

    public List<CustColor> getGravCenters() {
        return gravCenters;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public BufferedImage[] getThumbs() {
        return thumbs;
    }

    private VisualizationHelper(ClassificationFrame frame, MethodToApply method, AlgorithmToApply algorithm, String fileName, List<CustColor> gravCenters) {

        if (algorithm instanceof BasicAlgorithm) {
            algo = new BasicAlgorithmVIZ();
        } else if (algorithm instanceof BasicWithDiscardDistanceAlgorithm) {
            algo = new BasicWithDiscardDistanceAlgorithmVIZ();
        } else if (algorithm instanceof EqDistCountDoubleAlgorithm) {
            algo = new EqDistCountDoubleAlgorithmVIZ();
        } else if (algorithm instanceof AddToMultipleCentersAlgorithm) {
            algo = new AddToMultipleCentersAlgorithmVIZ();
        } else {
            algo = new AddToMultipleCentersMaxDistAlgorithmVIZ();
        }
        colloredForCenter = new HashMap<>();
        this.gravCenters = gravCenters;
        originalFilename = fileName;
        frame.notifyVizuStarted();
        try {
            ClassificationResultWithVisualization rezu = algo.classifyImage(new File(originalFilename),
                    method, gravCenters);

            File origFile = new File(originalFilename);

            originalFile = ImageIO.read(origFile);
            double proc = ((double) THUMB_HEIGHT) / originalFile.getHeight();
            Map<CustColor, List<int[]>> map = rezu.getPixelsToBeColored();
            int i = 1;

            thumbs = new BufferedImage[map.size() + 1];
            thumbs[0] = ImageTools.getScaledImage(originalFile, (int) (originalFile.getWidth() * proc), THUMB_HEIGHT);
            for (CustColor c : map.keySet()) {
                File newFile = new File("tmp_" + i);
                copyFile(origFile, newFile);

                BufferedImage tmp = ImageIO.read(newFile);
                colloredForCenter.put(c, tmp);
                Iterator<int[]> ite = map.get(c).iterator();
                while (ite.hasNext()) {
                    int[] next = ite.next();
                    float[] values = c.getValues();
                    Color cc = new Color((int) values[0], (int) values[1], (int) values[2]);
                    tmp.setRGB(next[0], next[1], cc.getRGB());
                }
                proc = ((double) THUMB_HEIGHT) / tmp.getHeight();
                thumbs[i] = ImageTools.getScaledImage(tmp, (int) (tmp.getWidth() * proc), THUMB_HEIGHT);
                i++;
            }
            frame.notifyVizuEnd();
        } catch (IOException ex) {
            frame.notifyVizuEnd();
            Logger.getLogger(VisualizationHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }

    public static VisualizationHelper init(ClassificationFrame frame, MethodToApply method, AlgorithmToApply algorithm, String fileName, List<CustColor> gravCenters) {
        if (instance != null && instance.getOriginalFilename().equals(fileName) && gravCenters.equals(gravCenters)) {
            return instance;
        }
        return instance = new VisualizationHelper(frame, method, algorithm, fileName, gravCenters);
    }
}
