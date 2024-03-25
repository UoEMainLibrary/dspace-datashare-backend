/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.model.hateoas;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.dspace.app.rest.model.DatashareLicenseRest;
import org.dspace.app.rest.model.hateoas.annotations.RelNameDSpaceResource;

/**
 * DatashareLicense Rest HAL Resource. The HAL Resource wraps the REST Resource adding
 * support for the links and embedded resources
 *
 * @author Luigi Andrea Pascarelli (luigiandrea.pascarelli at 4science.it)
 */
@RelNameDSpaceResource(DatashareLicenseRest.NAME)
public class DatashareLicenseResource extends HALResource {

    @JsonUnwrapped
    private DatashareLicenseRest data;

    public DatashareLicenseResource(DatashareLicenseRest entry) {
        super(entry);
    }

    public DatashareLicenseRest getData() {
        return data;
    }

}
