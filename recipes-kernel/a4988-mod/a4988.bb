SUMMARY = ""

DESCRIPTION = ""

LICENSE = "GPL"

#
# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

inherit module

# file://<filename>

SRC_URI += " \
	file://Makefile \
"

S = "${WORKDIR}"

