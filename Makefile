# $Id: Makefile,v 1.8 2011/02/14 20:51:12 - - bbracken $
# Stewart Bracken
# bbracken@ucsc.edu

JAVASRC    = jxref.java auxlib.java treemap.java queue.java visitor.java
SOURCES    = ${JAVASRC} Makefile
ALLSOURCES = ${SOURCES}
MAINCLASS  = jxref
CLASSES    = ${patsubst %.java, %.class, ${JAVASRC}}
INNCLASSES = jxref\$$printer.class treemap\$$node.class \
             queue\$$itor.class queue\$$node.class
JARCLASSES = ${CLASSES} ${INNCLASSES}
JARFILE    = jxref
LISTING    = ../asg3j-jxref.code.ps
SUBMITDIR  = cmps012b-wm.w11 asg3

all : ${JARFILE}

${JARFILE} : ${CLASSES}
	echo Main-class: ${MAINCLASS} >Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	chmod +x ${JARFILE}
	- rm Manifest

%.class : %.java
	cid + $<
	javac -Xlint $<

clean :
	- rm ${JARCLASSES}
	- rm queue\$$1.class
	- rm treemap\$$1.class

spotless : clean
	- rm ${JARFILE}

ci : ${SOURCES}
	cid + ${SOURCES}

submit : ${SOURCES}
	submit ${SUBMITDIR} ${SOURCES}

again : 
	gmake --no-print-directory spotless ci all lis

