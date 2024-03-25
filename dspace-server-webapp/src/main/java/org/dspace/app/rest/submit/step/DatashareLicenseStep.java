/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.submit.step;

import javax.servlet.http.HttpServletRequest;

import org.dspace.app.rest.exception.UnprocessableEntityException;
import org.dspace.app.rest.model.patch.Operation;
import org.dspace.app.rest.model.step.DataDatashareLicense;
import org.dspace.app.rest.submit.AbstractProcessingStep;
import org.dspace.app.rest.submit.SubmissionService;
import org.dspace.app.rest.submit.factory.PatchOperationFactory;
import org.dspace.app.rest.submit.factory.impl.PatchOperation;
import org.dspace.app.util.SubmissionStepConfig;
import org.dspace.content.InProgressSubmission;

import org.dspace.core.Context;

/**
 * License step for DSpace Spring Rest. Expose the license information about the in progress submission.
 *
 * @author Luigi Andrea Pascarelli (luigiandrea.pascarelli at 4science.it)
 */
public class DatashareLicenseStep extends AbstractProcessingStep {

   

    @Override
    public DataDatashareLicense getData(SubmissionService submissionService, InProgressSubmission obj,
            SubmissionStepConfig config)
        throws Exception {
         DataDatashareLicense result = new  DataDatashareLicense();
    // TO IMPLEMENT
        return result;
    }

    @Override
    public void doPatchProcessing(Context context, HttpServletRequest currentRequest, InProgressSubmission source,
            Operation op, SubmissionStepConfig stepConf) throws Exception {

        if (op.getPath().endsWith(DATASHARE_LICENSE_STEP_OPERATION_ENTRY)) {

            PatchOperation<String> patchOperation = new PatchOperationFactory()
                .instanceOf(DATASHARE_LICENSE_STEP_OPERATION_ENTRY, op.getOp());
            patchOperation.perform(context, currentRequest, source, op);

        } else {
            throw new UnprocessableEntityException("The path " + op.getPath() + " cannot be patched");
        }
    }
}
