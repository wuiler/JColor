package com.diogonunes.jcdp.color.api;

import com.diogonunes.jcdp.bw.api.AbstractPrinter;
import com.diogonunes.jcdp.color.api.Ansi.Attribute;
import com.diogonunes.jcdp.color.api.Ansi.BColor;
import com.diogonunes.jcdp.color.api.Ansi.FColor;

/**
 * This class is a template of a Colored Printer, hence it contains what is
 * common to each Colored Printer implementation offered by the library. Each
 * Colored Printer of this package should extend this class and thus implement
 * {@link com.diogonunes.jcdp.color.ColoredPrinter} interface.
 *
 * @author Diogo Nunes
 * @version 1.2 beta
 */
public abstract class AbstractColoredPrinter extends AbstractPrinter implements IColoredPrinter {

    private Attribute _attribute;
    private FColor _foregroundColor;
    private BColor _backgroundColor;

    // =====================
    // GET and SET METHODS
    // =====================

    /**
     * @return the current attribute; every message will be printed formatted
     * with this attribute.
     */
    protected Attribute getAttribute() {
        return _attribute;
    }

    /**
     * @return the current foreground color; every message will be printed with
     * this foreground color.
     */
    protected FColor getForegroundColor() {
        return _foregroundColor;
    }

    /**
     * @return the current background color; every message will be printed with
     * this background color.
     */
    protected BColor getBackgroundColor() {
        return _backgroundColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAttribute(Attribute a) {
        _attribute = a;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setForegroundColor(FColor c) {
        _foregroundColor = c;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBackgroundColor(BColor c) {
        _backgroundColor = c;
    }

    // ===============
    // OTHER METHODS
    // ===============

    @Override
    @Deprecated
    public void clear() {
        setAttribute(Attribute.CLEAR);
        setForegroundColor(FColor.NONE);
        setBackgroundColor(BColor.NONE);
        print(""); // refresh terminal line, so that the changes take immediate effect
    }

    //TODO should be Ansi.generateCode(), not a printer's responsibility
    @Override
    @Deprecated
    public String generateCode() {
        Attribute attr = getAttribute();
        FColor fColor = getForegroundColor();
        BColor bColor = getBackgroundColor();

        return generateCode(attr, fColor, bColor);
    }

    //TODO should be Ansi.generateCode(), not a printer's responsibility
    @Override
    @Deprecated
    public String generateCode(Attribute attr, FColor fg, BColor bg) {
        return Ansi.generateCode(attr, fg, bg);
    }
}