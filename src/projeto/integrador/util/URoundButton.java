/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador.util;

import java.awt.Dimension;

import java.awt.geom.Ellipse2D;

import javax.swing.Action;
import javax.swing.Icon;

/**
 *
 * @author chailonm
 */
public class URoundButton extends URoundedCornerButton {

    public URoundButton() {
        
        super();
    }

    public URoundButton(Icon icon) {
        
        super(icon);
    }

    public URoundButton(String text) {
        
        super(text);
    }

    public URoundButton(Action a) {
        
        super(a);
    }

    public URoundButton(String text, Icon icon) {
        
        super(text, icon);
    }

    @Override
    public Dimension getPreferredSize() {
        
        Dimension d = super.getPreferredSize();
        
        int s = Math.max(d.width, d.height);
        
        d.setSize(s, s);
        
        return d;
    }

    @Override
    protected void initShape() {
        
        if (!getBounds().equals(base)) {
            
            base = getBounds();
            
            shape = new Ellipse2D.Float(0, 0, getWidth() - 1, getHeight() - 1);
            border = new Ellipse2D.Float(FOCUS_STROKE, FOCUS_STROKE,
                    getWidth() - 1 - FOCUS_STROKE * 2,
                    getHeight() - 1 - FOCUS_STROKE * 2);
        }
    }
}