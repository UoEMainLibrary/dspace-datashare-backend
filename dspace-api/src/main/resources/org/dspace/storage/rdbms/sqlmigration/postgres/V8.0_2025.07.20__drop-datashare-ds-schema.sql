--
-- The contents of this file are subject to the license and copyright
-- detailed in the LICENSE and NOTICE files at the root of the source
-- tree and available online at
--
-- http://www.dspace.org/license/
--

-----------------------------------------------------------------------
-- Drop the 'ds' metadata schema that was used as an intermediate layer
-- during Datashare form submission. All Datashare steps now write
-- directly to standard dc.* fields, so ds.* is no longer needed.
--
-- This migration:
--   1. Deletes any metadata VALUES stored under ds.* fields
--   2. Deletes the ds.* field definitions from metadatafieldregistry
--   3. Deletes the ds schema from metadataschemaregistry
-----------------------------------------------------------------------

-- Step 1: Delete metadata values referencing ds.* fields
DELETE FROM metadatavalue
WHERE metadata_field_id IN (
    SELECT mfr.metadata_field_id
    FROM metadatafieldregistry mfr
    JOIN metadataschemaregistry msr ON mfr.metadata_schema_id = msr.metadata_schema_id
    WHERE msr.short_id = 'ds'
);

-- Step 2: Delete ds.* field definitions
DELETE FROM metadatafieldregistry
WHERE metadata_schema_id = (
    SELECT metadata_schema_id FROM metadataschemaregistry WHERE short_id = 'ds'
);

-- Step 3: Delete the ds schema itself
DELETE FROM metadataschemaregistry WHERE short_id = 'ds';
