/* 
 * ChangelogDialog.java
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

package eu.mihosoft.vrl.system;

import eu.mihosoft.vrl.visual.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.*;
import javax.swing.text.DefaultCaret;


/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class ChangelogDialog {
    
    public static void showDialog() {
        showDialog(VRL.getCurrentProjectController().getCurrentCanvas());
    }

    public static void showDialog(Canvas canvas) {

        _HTMLLabel2 pane = new _HTMLLabel2();

        // tried to force linebreak if inside pre element
        // does break in the middle of a word (which is bad)
//        pane.setText("<font size=+1>" + VRL.getChangelog());
//        String[] changelog = VRL.getChangelog().split("\n");
//        
//        String finalChangelog = "";
//        
//        for (String l : changelog) {
//            if (l.length() > 80) {
//                l = l.substring(0, 79) + "\n" + l.substring(79, l.length());
//            }
//            
//            finalChangelog += l + "\n";
//        }
        
        String finalChangelog = VRL.getChangelog().
                replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;");
        
        pane.setText(finalChangelog);

        VConstrainedScrollPane scrollPane =
                new VConstrainedScrollPane(pane);

        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.setMaxWidth(580);
        scrollPane.setMaxHeight(620);
        
//        scrollPane.getViewport().setViewPosition(new Point(0,0));
//        scrollPane.getVerticalScrollBar().setValue(0);

        VDialog.showDialogWindow(
                canvas, "VRL Changelog",
                scrollPane, "Close", true);

    }
}
class _HTMLLabel2 extends JEditorPane {

    private VComponent vParent;

    public _HTMLLabel2() {
        this.setBackground(VSwingUtil.TRANSPARENT_COLOR);
        this.setContentType("text/html");
        this.setOpaque(false);
        this.setEditable(false);
        
        DefaultCaret caret = (DefaultCaret)getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
    }

    @Override
    protected void paintComponent(Graphics g) {

        if (vParent == null) {
            setParent((VComponent) VSwingUtil.getParent(this, VComponent.class));
        }

        if (vParent != null) {
            this.setForeground(vParent.getStyle().getBaseValues().
                    getColor(Canvas.TEXT_COLOR_KEY));
        }

        super.paintComponent(g);
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(VComponent parent) {
        this.vParent = parent;
    }
    
    private void _setText(String text) {

        String textColor = "white";
        try {
            final Color color = vParent.getStyle().
                    getBaseValues().getColor(Canvas.TEXT_COLOR_KEY);
            textColor = Integer.toHexString(color.getRGB()).
                    substring(2);
        } catch (Exception ex) {
            //
        }

        String htmlHeader = "<html><body text=\"" + textColor + "\">";
        String htmlFooter = "</body></html>";
        super.setText(htmlHeader + text + htmlFooter);
    }
    
    @Override
    public void setText(String text) {
        _setText(text);
    }
}
