
# DSpace (Edinburgh DataShare fork — 8.2 → 8.3 upgrade)

> **Working branch:** `uoe/upgrade-to-83`
> **Source baseline:** `origin/datashare-UoEMainLibrary-dspace-8_x` (DSpace 8.2 + DataShare customisations)
> **Target baseline:** `upstream/UoEMainLibrary-dspace-8_x` (DSpace 8.3)
> See the [Upgrade Progress](#upgrade-progress-82--83) section below for the live tracker.

---

# DSpace

[![Build Status](https://github.com/DSpace/DSpace/workflows/Build/badge.svg)](https://github.com/DSpace/DSpace/actions?query=workflow%3ABuild)

[DSpace Documentation](https://wiki.lyrasis.org/display/DSDOC/) |
[DSpace Releases](https://github.com/DSpace/DSpace/releases) |
[DSpace Wiki](https://wiki.lyrasis.org/display/DSPACE/Home) |
[Support](https://wiki.lyrasis.org/display/DSPACE/Support)

## Overview

DSpace open source software is a turnkey repository application used by more than
2,000 organizations and institutions worldwide to provide durable access to digital resources.
For more information, visit http://www.dspace.org/

DSpace consists of both a Java-based backend and an Angular-based frontend.

* Backend (this codebase) provides a REST API, along with other machine-based interfaces (e.g. OAI-PMH, SWORD, etc)
    * The REST Contract is at https://github.com/DSpace/RestContract
* Frontend (https://github.com/DSpace/dspace-angular/) is the User Interface built on the REST API

Prior versions of DSpace (v6.x and below) used two different UIs (XMLUI and JSPUI). Those UIs are no longer supported in v7 and above.
* A maintenance branch for older versions is still available, see `dspace-6_x` for 6.x maintenance.

## Downloads

* Backend (REST API): https://github.com/DSpace/DSpace/releases
* Frontend (User Interface): https://github.com/DSpace/dspace-angular/releases

## Documentation / Installation

Documentation for each release may be viewed online or downloaded via our [Documentation Wiki](https://wiki.lyrasis.org/display/DSDOC/).

The latest DSpace Installation instructions are available at:
https://wiki.lyrasis.org/display/DSDOC8x/Installing+DSpace

Please be aware that, as a Java web application, DSpace requires a database (PostgreSQL)
and a servlet container (usually Tomcat) in order to function.
More information about these and all other prerequisites can be found in the Installation instructions above.

## Running DSpace 8 in Docker

NOTE: At this time, we do not have production-ready Docker images for DSpace.
That said, we do have quick-start Docker Compose scripts for development or testing purposes.

See [Running DSpace 8 with Docker Compose](dspace/src/main/docker-compose/README.md)

## Contributing

See [Contributing documentation](CONTRIBUTING.md)

## Getting Help

DSpace provides public mailing lists where you can post questions or raise topics for discussion.
We welcome everyone to participate in these lists:

* [dspace-community@googlegroups.com](https://groups.google.com/d/forum/dspace-community) : General discussion about DSpace platform, announcements, sharing of best practices
* [dspace-tech@googlegroups.com](https://groups.google.com/d/forum/dspace-tech) : Technical support mailing list. See also our guide for [How to troubleshoot an error](https://wiki.lyrasis.org/display/DSPACE/Troubleshoot+an+error).
* [dspace-devel@googlegroups.com](https://groups.google.com/d/forum/dspace-devel) : Developers / Development mailing list

Great Q&A is also available under the [DSpace tag on Stackoverflow](http://stackoverflow.com/questions/tagged/dspace)

Additional support options are at https://wiki.lyrasis.org/display/DSPACE/Support

DSpace also has an active service provider network. If you'd rather hire a service provider to
install, upgrade, customize, or host DSpace, then we recommend getting in touch with one of our
[Registered Service Providers](http://www.dspace.org/service-providers).

## Issue Tracker

DSpace uses GitHub to track issues:
* Backend (REST API) issues: https://github.com/DSpace/DSpace/issues
* Frontend (User Interface) issues: https://github.com/DSpace/dspace-angular/issues

## Testing

### Running Tests

By default, in DSpace, Unit Tests and Integration Tests are disabled. However, they are
run automatically by [GitHub Actions](https://github.com/DSpace/DSpace/actions?query=workflow%3ABuild) for all Pull Requests and code commits.

* How to run both Unit Tests (via `maven-surefire-plugin`) and Integration Tests (via `maven-failsafe-plugin`):
  ```
  mvn install -DskipUnitTests=false -DskipIntegrationTests=false
  ```
* How to run _only_ Unit Tests:
  ```
  mvn test -DskipUnitTests=false
  ```
* How to run a *single* Unit Test
  ```
  # Run all tests in a specific test class
  # NOTE: failIfNoTests=false is required to skip tests in other modules
  mvn test -DskipUnitTests=false -Dtest=[full.package.testClassName] -DfailIfNoTests=false

  # Run one test method in a specific test class
  mvn test -DskipUnitTests=false -Dtest=[full.package.testClassName]#[testMethodName] -DfailIfNoTests=false
  ```
* How to run _only_ Integration Tests
  ```
  mvn install -DskipIntegrationTests=false
  ```
* How to run a *single* Integration Test
  ```
  # Run all integration tests in a specific test class
  # NOTE: failIfNoTests=false is required to skip tests in other modules
  mvn install -DskipIntegrationTests=false -Dit.test=[full.package.testClassName] -DfailIfNoTests=false

  # Run one test method in a specific test class
  mvn install -DskipIntegrationTests=false -Dit.test=[full.package.testClassName]#[testMethodName] -DfailIfNoTests=false
  ```
* How to run only tests of a specific DSpace module
  ```
  # Before you can run only one module's tests, other modules may need to be installed into your ~/.m2
  cd [dspace-src]
  mvn clean install

  # Then, move into a module subdirectory, and run the test command
  cd [dspace-src]/dspace-server-webapp
  # Choose your test command from the lists above
  ```

## License

DSpace source code is freely available under a standard [BSD 3-Clause license](https://opensource.org/licenses/BSD-3-Clause).
The full license is available in the [LICENSE](LICENSE) file or online at http://www.dspace.org/license/

DSpace uses third-party libraries which may be distributed under different licenses. Those licenses are listed
in the [LICENSES_THIRD_PARTY](LICENSES_THIRD_PARTY) file.


---

## Upgrade Progress (8.2 ? 8.3)

_Updated: 2026-04-22 (initial seeding)_

### Overview
- **Working branch:** `uoe/upgrade-to-83`
- **Starting commit:** `8e4f3ee191` (== `origin/datashare-UoEMainLibrary-dspace-8_x`)
- **Target:** merge of `upstream/UoEMainLibrary-dspace-8_x` @ `c14eb477a6` ("Merge backend dspace8.3 into UoEMainLibrary-dspace-8_x #10")
- **Merge-base:** `c7a6e7511c` (post-8.2 merge commit)
- **Scope at start:** 281 files changed upstream vs. local (+8,239 / -15,994)

### Customizations Inventory (from MIGRATION-ASSESSMENT.md)

| # | Area | Status in 8.2 fork | Upgrade-sensitive? |
|---|------|--------------------|--------------------|
| 1 | EASE/Shibboleth Auth � `DATASHARE_USERS` injection in `StatelessAuthenticationFilter` | Migrated (partial; EASE/LDAP dropped) | Yes � auth framework changed in 8.3 (review only; filter itself not touched upstream) |
| 2 | DOI/DataCite � `DataCiteConnector` (lines 430-463), `DIM2DataCite.xsl`, `DatashareDoiCitationUpdaterCLI` | Fully migrated | Low |
| 3 | Embargo � `EmbargoServiceImpl` (lines 258-378), `DefaultEmbargoSetter` | Migrated, unstable history | **High** � `DefaultEmbargoSetter` is a named critical conflict in 8.3 |
| 4 | Dataset / ItemDataset � `DatashareDataset*`, REST controller, DAO/service, Flyway `V8.0_*` migrations, 3 submission steps | Fully migrated | Low (additive) |
| 5 | SWORD � `SimpleZipContentIngester` zip-slip fix | Migrated (SWORDAuthentication dropped) | Low |
| 6 | File Preview | Missing | N/A � out of scope for 8.3 upgrade |
| 7 | IRUS-UK | Deliberately disabled (`8f844fa427`) | Low |
| 8 | ClamAV � `ClamScan` null-safe bundle handling | Migrated | Low |
| 9 | UI / Branding | Frontend-only | Out of scope for backend |
| 10 | Config & Infra � `submission-forms.xml`, `item-submission.xml`, `discovery.xml`, `hibernate.cfg.xml`, `dspace.cfg`, `launcher.xml`, Flyway `V8.0_2024.10.16`, `V8.0_2025.02.12`, `V8.0_2025.04.11`, email templates, JACS vocab, `cc-by.license` | Fully migrated | Config merges required |
| 11 | `ItemServiceImpl` customisations | Migrated (+90 lines) | **High** � upstream 8.3 also changes this file (+136 lines) |

### Expected Critical Conflicts (from assessment)
1. `dspace-api/src/main/java/org/dspace/embargo/DefaultEmbargoSetter.java` � preserve DATASHARE embargo logic while taking upstream bundle-policy fix.
2. `dspace-api/src/main/java/org/dspace/content/ItemServiceImpl.java` � line-by-line review; both sides changed heavily.
3. `dspace/config/submission-forms.xml` � small upstream change overlays large DataShare form set.
4. `dspace/config/dspace.cfg` � additive customer config + small upstream bump.
5. Auth files touched upstream: `ShibAuthentication.java`, `AuthenticationMethod.java`, `LDAPAuthentication.java`, `WebSecurityConfiguration.java` (no local diff expected � straight accept upstream).
6. New upstream Flyway: `V7.6_2025.10.29__Fix-request-items-with-deleted-bitstreams.sql` (additive, no local overlap).

### Status Log
- [x] 2026-04-22 — Repo + remotes analysed. `upstream` remote added → `https://github.com/UoEMainLibrary/dspace-datashare-backend.git`. Branch `UoEMainLibrary-dspace-8_x` fetched (HEAD `c14eb477a6`).
- [x] 2026-04-22 — Branch `uoe/upgrade-to-83` confirmed checked out and clean.
- [x] 2026-04-22 — Customisations inventory compiled (see table above).
- [x] 2026-04-22 — Merge `upstream/UoEMainLibrary-dspace-8_x` into `uoe/upgrade-to-83` completed. 281 files changed. **Only 4 conflicts** (vs. expected 6+); all resolved (see table below). Merge commit `328e4342f6`.
- [x] 2026-04-22 — Build `mvn -B -DskipTests package` → **BUILD SUCCESS** (all 14 modules, 53.6s sequential).
- [x] 2026-04-22 — Checkstyle: **0 violations** across all modules.
- [x] 2026-04-22 — Unit tests: **PASS** (`mvn install -DskipUnitTests=false -DskipIntegrationTests=true`). Totals: 76 (dspace-services) + 1176 (dspace-api) + 9 + 156 (dspace-server-webapp) = **1417 tests, 0 failures, 0 errors, 11 skipped**.
- [x] 2026-04-22 — Integration tests: **PASS** after two known-flaky/env issues documented (see table). `dspace-api` IT: 437 tests (1 flaky time-assertion passed on rerun; 2 Docker-dependent S3 tests cannot run locally). `dspace-server-webapp` IT: **3259/3259 PASS**, 27 skipped, 0 failures, 0 errors. `server` module IT: 1/1 PASS.
- [ ] Push final branch to `origin/uoe/upgrade-to-83` (awaiting user confirmation).

### Issues and Resolutions

| # | Symptom | Root Cause | Fix | Impact / Risk |
|---|---------|------------|-----|---------------|
| 1 | Merge conflict in `dspace-api/.../embargo/DefaultEmbargoSetter.java` | Comment-only delta around removePoliciesActionFilter call | Kept upstream 8.3 version (comment-only change, no behaviour change) | None |
| 2 | Merge conflict in `dspace-api/src/test/.../DSpaceHttpClientFactoryTest.java` | Upstream CI-stability fix using `InetAddress.getByAddress` in two proxy tests | `git checkout --theirs` (upstream fix) | Test-only, improves reliability |
| 3 | Merge conflict in `dspace-server-webapp/.../curate/CurationScriptIT.java` | Comment-only delta | `git checkout --theirs` | None |
| 4 | Merge conflict in `dspace/config/submission-forms.xml` | Upstream added `openaire_types` value-pairs block (~291 lines) overlapping with UoE `countries`/`coverage` block | Kept UoE `countries` block; appended upstream `openaire_types` block with its preceding comment. XML validated. | Submission form gains OpenAIRE document types while retaining DataShare countries vocabulary |
| 5 | Parallel build `-T 1C` failed: assembly couldn't find `server-boot` jar | Thread scheduling skipped `server-boot` | Sequential `mvn -B -DskipTests package` (no `-T`) | Build-infra only |
| 6 | Unit tests initially errored with "dspace.dir not set" | Running `mvn test` directly skips the root profile that assembles the `testEnvironment.zip` | Use `mvn install -DskipUnitTests=false` (per project README) — the test env is generated during `generate-test-resources` of the parent module | Docs/process |
| 7 | IT `ChecksumCheckerIT.testChecksumsRecordedWhenProcesingIsInterrupted` asserted `lastChecksumDate <= checkerStartDate` with 45 ms delta | Known flaky clock-comparison assertion (timestamp precision on Windows) | Re-ran the single test → **PASS**. Not a regression. Track upstream. | Low (transient) |
| 8 | IT `S3BitStoreServiceIT` → `Could not find a valid Docker environment` | Testcontainers requires a running Docker daemon (MinIO/S3 emulator). None on dev machine. | Env-only — test is skipped/errored when Docker is absent; identical behaviour on the 8.2 baseline. Not a regression. | None (env) |

### Open Risks and Next Steps
- **Embargo stability** — commit history shows prior disable/enable cycles; recommend a focused regression test on embargo lifecycle after deploy.
- **Auth framework (8.3)** — manually verify `DATASHARE_USERS` injection still triggers after Shib login in a staging environment (no IT covers this path).
- **Docker-dependent ITs** — `S3BitStoreServiceIT` needs a Docker-enabled CI runner; document in CI README if not already.
- **Frontend items out of scope** — File Preview and UI/branding are tracked in the Angular repo, not here.
- **No force pushes** — working branch will be pushed non-force only after this tracker is approved.

