/* 
 * VGeometry3DAppearance.java
 * 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2009–2012 Steinbeis Forschungszentrum (STZ Ölbronn),
 * Copyright (c) 2006–2012 by Michael Hoffer
 * 
 * This file is part of Visual Reflection Library (VRL).
 *
 * VRL is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 * 
 * see: http://opensource.org/licenses/LGPL-3.0
 *      file://path/to/VRL/src/eu/mihosoft/vrl/resources/license/lgplv3.txt
 *
 * VRL is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * This version of VRL includes copyright notice and attribution requirements.
 * According to the LGPL this information must be displayed even if you modify
 * the source code of VRL. Neither the VRL Canvas attribution icon nor any
 * copyright statement/attribution may be removed.
 *
 * Attribution Requirements:
 *
 * If you create derived work you must do three things regarding copyright
 * notice and author attribution.
 *
 * First, the following text must be displayed on the Canvas:
 * "based on VRL source code". In this case the VRL canvas icon must be removed.
 * 
 * Second, the copyright notice must remain. It must be reproduced in any
 * program that uses VRL.
 *
 * Third, add an additional notice, stating that you modified VRL. In addition
 * you must cite the publications listed below. A suitable notice might read
 * "VRL source code modified by YourName 2012".
 * 
 * Note, that these requirements are in full accordance with the LGPL v3
 * (see 7. Additional Terms, b).
 *
 * Publications:
 *
 * M. Hoffer, C.Poliwoda, G.Wittum. Visual Reflection Library -
 * A Framework for Declarative GUI Programming on the Java Platform.
 * Computing and Visualization in Science, 2011, in press.
 */

package eu.mihosoft.vrl.v3d;

import java.awt.Color;
import java.io.Serializable;
import javax.media.j3d.Material;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class VGeometry3DAppearance implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Color wireColor;
    private Color solidColor;
    private Float wireThickness = 0.5F;
    private Boolean lighting = false;
    private int vertexColoringType = Material.DIFFUSE;
    private boolean vertexColoring = false;
    private boolean volumeRendering = false;

    public VGeometry3DAppearance() { 
    }

    public VGeometry3DAppearance(Color wireColor,
            Color solidColor, Float wireThickness, Boolean lighting,
            boolean vertexColoring) {
        this.wireColor = wireColor;
        this.solidColor = solidColor;
        this.wireThickness = wireThickness;
        this.lighting = lighting;
        this.vertexColoring = vertexColoring;
    }

    public VGeometry3DAppearance(Color wireColor,
            Color solidColor, Float wireThickness, Boolean lighting,
            boolean vertexColoring, int vertexColoringType,
            boolean volumeRendering) {
        this.wireColor = wireColor;
        this.solidColor = solidColor;
        this.wireThickness = wireThickness;
        this.lighting = lighting;
        this.vertexColoring = vertexColoring;
        this.vertexColoringType = vertexColoringType;
        this.volumeRendering = volumeRendering;
    }

    public VGeometry3DAppearance(Color wireColor,
            Color solidColor, Float wireThickness, Boolean lighting) {
        this.wireColor = wireColor;
        this.solidColor = solidColor;
        this.wireThickness = wireThickness;
        this.lighting = lighting;
    }

    /**
     * @return the wireColor
     */
    public Color getWireColor() {
        return wireColor;
    }

    /**
     * @param wireColor the wireColor to set
     */
    public void setWireColor(Color wireColor) {
        this.wireColor = wireColor;
    }

    /**
     * @return the solidColor
     */
    public Color getSolidColor() {
        return solidColor;
    }

    /**
     * @param solidColor the solidColor to set
     */
    public void setSolidColor(Color solidColor) {
        this.solidColor = solidColor;
    }

    /**
     * @return the wireThickness
     */
    public Float getWireThickness() {
        return wireThickness;
    }

    /**
     * @param wireThickness the wireThickness to set
     */
    public void setWireThickness(Float wireThickness) {
        this.wireThickness = wireThickness;
    }

    /**
     * @return the lighting
     */
    public Boolean getLighting() {
        return lighting;
    }

    /**
     * @param lighting the lighting to set
     */
    public void setLighting(Boolean lighting) {
        this.lighting = lighting;
    }

    /**
     * @return the vertexColoringType
     */
    public int getVertexColoringType() {
        return vertexColoringType;
    }

    /**
     * @param vertexColoringType the vertexColoringType to set
     */
    public void setVertexColoringType(int vertexColoringType) {
        this.vertexColoringType = vertexColoringType;
    }

    /**
     * @return the vertexColoring
     */
    public boolean isVertexColoring() {
        return vertexColoring;
    }

    /**
     * @param vertexColoring the vertexColoring to set
     */
    public void setVertexColoring(boolean vertexColoring) {
        this.vertexColoring = vertexColoring;
    }

    /**
     * @return the volumeRendering
     */
    public boolean isVolumeRendering() {
        return volumeRendering;
    }

    /**
     * @param volumeRendering the volumeRendering to set
     */
    public void setVolumeRendering(boolean volumeRendering) {
        this.volumeRendering = volumeRendering;
    }

}
