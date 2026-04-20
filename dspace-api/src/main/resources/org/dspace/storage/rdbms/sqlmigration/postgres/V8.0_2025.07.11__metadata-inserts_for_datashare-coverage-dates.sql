--
-- The contents of this file are subject to the license and copyright
-- detailed in the LICENSE and NOTICE files at the root of the source
-- tree and available online at
--
-- http://www.dspace.org/license/
--

-----------------------------------------------------------------------------------------------------------------------------------

-- Datashare: register dc.coverage.startDate and dc.coverage.endDate metadata fields
-- used by DatashareSpatialAndTemporalStep to capture temporal coverage dates.

-----------------------------------------------------------------------------------------------------------------------------------

-- Insert dc.coverage.startDate
INSERT INTO metadatafieldregistry (metadata_schema_id, element, qualifier)
  SELECT (SELECT metadata_schema_id FROM metadataschemaregistry WHERE short_id='dc'), 'coverage', 'startDate'
    WHERE NOT EXISTS (SELECT metadata_field_id FROM metadatafieldregistry WHERE element = 'coverage' AND qualifier='startDate' AND metadata_schema_id = (SELECT metadata_schema_id FROM metadataschemaregistry WHERE short_id='dc'));

-- Insert dc.coverage.endDate
INSERT INTO metadatafieldregistry (metadata_schema_id, element, qualifier)
  SELECT (SELECT metadata_schema_id FROM metadataschemaregistry WHERE short_id='dc'), 'coverage', 'endDate'
    WHERE NOT EXISTS (SELECT metadata_field_id FROM metadatafieldregistry WHERE element = 'coverage' AND qualifier='endDate' AND metadata_schema_id = (SELECT metadata_schema_id FROM metadataschemaregistry WHERE short_id='dc'));
