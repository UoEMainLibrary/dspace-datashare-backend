--
-- The contents of this file are subject to the license and copyright
-- detailed in the LICENSE and NOTICE files at the root of the source
-- tree and available online at
--
-- http://www.dspace.org/license/
--

CREATE TABLE report_result (
    report_result_id integer NOT NULL PRIMARY KEY,
    type varchar(256),
    value TEXT,
    executor_id UUID REFERENCES EPerson(uuid) ON DELETE SET NULL,
    args TEXT,
    last_modified TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
