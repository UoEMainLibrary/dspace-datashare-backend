/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.model;

/**
 * The License text REST resource.
 *
 * @author Luigi Andrea Pascarelli (luigiandrea.pascarelli at 4science.it)
 */
public class DatashareLicenseRest implements RestModel {
    public static final String NAME = "datasharelicense";
    private String dropdownValue;
    private String textAreaText;

    public String getdropdownValue() {
        return dropdownValue;
    }

    public void setdropdownValue(String dropdownValue) {
        this.dropdownValue = dropdownValue;
    }

    public String getTextAreaText() {
        return textAreaText;
    }

    public void setTextAreaText(String textAreaText) {
        this.textAreaText = textAreaText;
    }

    @Override
    public String getType() {
        return NAME;
    }
}
