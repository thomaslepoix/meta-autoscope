#!/bin/sh
### BEGIN INIT INFO
# Provides:		helloworld
# Required-Start:
# Required-Stop:
# Default-Start:	5
# Default-Stop:		0 1 6
# Short-Description:	Helloworld test
### END INIT INFO

NAME="helloworld"
DESC="Test program"
DAEMON="/usr/bin/${NAME}"
PIDFILE="/var/run/${NAME}.pid"

case "$1" in
	start)
		echo -n "Starting ${DESC}: ${NAME}... "
#		start-stop-daemon -S -b -C -q -x ${DAEMON} > /dev/tty3
		${DAEMON} > /dev/tty3 &
		echo $! > ${PIDFILE}
		echo "done"
		;;
	stop)
		echo -n "Stopping ${DESC}: ${NAME}... "
		start-stop-daemon -K -q -x ${DAEMON}
		rm ${PIDFILE}
		echo "done"
		;;
	restart)
		$0 stop
		$0 start
		;;
	status)
		start-stop-daemon -T -q -x ${DAEMON}
		case "$?" in
			0)
				echo "Program ${NAME} is running (`pidof ${NAME}`)."
				;;
			1)
				echo "Programm ${NAME} is not running and the pid file exists."
				;;
			3)
				echo "Programm ${NAME} is not running."
				;;
			4)
				echo "Unable to determine ${NAME} status."
				;;
			esac
		;;
	*)
		echo "Usage: $0 {start|stop|restart|status}"
		exit 1
		;;
	esac
exit 0

