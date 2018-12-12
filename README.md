# meta-autoscope

This README file contains information on building the meta-autoscope layer. Please see the corresponding sections below for details.

<br>

## Description

Yocto layer for automated telescope based on Raspberry-Pi 3.

<br>

## Dependencies

This layer depends on:

* URI: https://git.yoctoproject.org/git/poky
  * branch: sumo
  * revision: HEAD

* URI: https://git.yoctoproject.org/git/meta-freescale
  * branch: sumo
  * revision: HEAD

* URI: https://git.openembedded.org/meta-openembedded
  * layers: meta-oe, meta-multimedia, meta-networking, meta-python
  * branch: sumo
  * revision: HEAD

* URI: https://github.com/agherzan/meta-raspberrypi
  * branch: sumo
  * revision: HEAD

* URI: https://github.com/meta-qt5/meta-qt5
  * branch: sumo
  * revision: HEAD

<br>

## Usage

Download sources :

```
mkdir yocto-autoscope
cd yocto-autoscope
repo init -u https://github.com/thomaslepoix/meta-autoscope -b rpi-repo
repo sync
```


Work on this repository :

```
cd sources/meta-autoscope
git checkout rpi
```

Build image :

```
TEMPLATECONF="../meta-autoscope/conf" source sources/poky/oe-init-build-env rpi-build/ 
bitbake autoscope-base-image
```
