#!bin/sh
JAVA_HOME="${java_1_5_0}"

ANT_HOME="${ant_1_6_2}"

#JAVA_HOME="${JAVA_HOME}"
#ANT_HOME="${ANT_HOME}"

PATH="${ANT_HOME}/bin:${JAVA_HOME}/bin:${PATH}"

export JAVA_HOME ANT_HOME PATH

ant jar

if [ $? -ne 0 ]; then exit 1 ; fi

