# $Id: Makefile,v 1.1 2011-01-28 19:52:24-08 - - $

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
SUBMITDIR  = cmps012b-wm.f10 asg3

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
	- rm ${JARCLASSES} Manifest

spotless : clean
	- rm ${JARFILE}

ci : ${SOURCES}
	cid + ${SOURCES}

lis : ${SOURCES}
	mkpspdf ${LISTING} ${SOURCES}

submit : ${SOURCES}
	submit ${SUBMITDIR} ${SOURCES}

again : 
	gmake --no-print-directory spotless ci all lis

