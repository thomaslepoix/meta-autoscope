# meta-autoscope

This README file contains information on building the meta-autoscope layer. Please see the corresponding sections below for details.

<br>

## Description

Yocto meta layer for automated telescope on PICO-PI-IMX7.

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

* URI: https://github.com/Freescale/meta-freescale-3rdparty
  * branch: sumo
  * revision: HEAD

* URI: https://github.com/Freescale/meta-freescale-distro
  * branch: sumo
  * revision: HEAD

* URI: https://github.com/jorisoffouga/meta-picopi-imx7d
  * branch: master
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
repo init -u https://github.com/thomaslepoix/meta-autoscope -b repo
repo sync
```

Build image :

```
source setup-environnement autoscope-build/ 
bitbake autoscope-base-image
```
