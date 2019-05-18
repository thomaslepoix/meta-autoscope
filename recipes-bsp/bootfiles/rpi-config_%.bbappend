#RPI_USE_U_BOOT = "1"
BOOT_DELAY = "1"

VIDEO_CAMERA = "1"
GPU_MEM = "128"

ENABLE_UART = "1"
ENABLE_I2C = "1"

RPI_EXTRA_CONFIG = "\n\
dtoverlay=pi3-disable-bt\n\
dtparam=act_led_trigger=off\n\
disable_camera_led=1\n\
"
