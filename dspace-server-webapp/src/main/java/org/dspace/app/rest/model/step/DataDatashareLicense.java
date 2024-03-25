/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

 package org.dspace.app.rest.model.step;
 
/**
 * Java Bean to expose the section Datashare License during in progress submission.
 */
public class DataDatashareLicense implements SectionData {

  public static final String OTHER_RIGHTS = "Other";

  private String dropdownValue;
  private String textAreaText;

  public String getRights() {
    return this.dropdownValue.equals(OTHER_RIGHTS)? this.textAreaText : this.dropdownValue;
  }

  public String getDropdownValue() {
    return dropdownValue;
  }

  public String getTextAreaText() {
    return textAreaText;
  }
  
}
