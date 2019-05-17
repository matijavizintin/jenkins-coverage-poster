#!/usr/bin/env groovy

def call(Map args) {
  final Double coverageThreshold = args.threshold ?: 80.0
  final Double coverageDeltaThreshold = args.deltaThreshold ?: null
  final String reportPath = args.reportPath ?: "coverage.out"

  final lib = new com.spotify.jenkinsfile.Coverage()

  final Double coverage = lib.getCoverageFromReport(reportPath)
  lib.postCoverage(coverage, coverageThreshold)

  final Double coverageDelta = lib.getCoverageDelta()
  lib.postCoverageDelta(coverageDelta, coverageDeltaThreshold)
}
