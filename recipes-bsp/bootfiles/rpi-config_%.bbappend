#RPI_USE_U_BOOT = "1"
BOOT_DELAY = "0"

# disable_camera_led=1
# dtoverlay=pi3-disable-bt
VIDEO_CAMERA = "1"
GPU_MEM = "128"

ENABLE_UART = "1"
ENABLE_I2C = "1"

RPI_EXTRA_CONFIG = "\n\
dtparam=act_led_trigger=off\n\
disable_camera_led=1\n\
"
