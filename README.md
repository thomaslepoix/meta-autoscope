# meta-autoscope

This README file contains information on building the meta-autoscope layer. Please see the corresponding sections below for details.

<br>

## Description

Yocto meta layer for automated telescope on PICO-PI-IMX7.

<br>

## Dependencies

This layer depends on:

* URI: git://git.yoctoproject.org/poky
  * branch: master
  * revision: HEAD

* URI: git://git.openembedded.org/meta-openembedded
  * layers: meta-oe, meta-multimedia, meta-networking, meta-python
  * branch: master
  * revision: HEAD

* URI: https://github.com/Freescale/meta-freescale.git
  * branch: master
  * revision: HEAD

* URI: https://github.com/Freescale/meta-freescale-3rdparty.git
  * branch: master
  * revision: HEAD

* URI: https://github.com/jorisoffouga/meta-picopi-imx7d.git
  * branch: master
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
