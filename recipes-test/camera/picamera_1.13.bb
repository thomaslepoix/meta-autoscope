DESCRIPTION = "Picamera library recipe"
HOMEPAGE = "https://picamera.readthedocs.io/en/release-1.13/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a5f6282f39d52726bdc1e51d5c4b95c9"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

#SRC_URI = "git://github.com/waveform80/picamera;protocol=git"
SRCREV = "${AUTOREV}"

#https://files.pythonhosted.org/packages/79/c4/80afe871d82ab1d5c9d8f0c0258228a8a0ed96db07a78ef17e7fba12fda8/picamera-1.13.tar.gz

SRC_URI += "file://0001-Skip-rpi-platform-check.patch"
SRC_URI[sha256sum] = "890815aa01e4d855a6a95dd3ad0953b872a6b954982106407df0c5a31a163e50"
#PYPI_PACKAGE = "picamera.camera"
#inherit pypi distutils

inherit pypi setuptools3

COMPATIBLE_MACHINE = "^rpi$"
#S = "${WORKDIR}/git"
