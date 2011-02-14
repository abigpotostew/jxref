<<<<<<< HEAD
# $Id: Makefile,v 1.8 2011-02-14 12:51:12-08 - - $
# Stewart Bracken
# bbracken@ucsc.edu
=======
# $Id: Makefile,v 1.1 2011-01-28 19:52:24-08 - - $
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1

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
<<<<<<< HEAD
SUBMITDIR  = cmps012b-wm.w11 asg3
=======
SUBMITDIR  = cmps012b-wm.f10 asg3
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1

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
<<<<<<< HEAD
	- rm ${JARCLASSES}
	- rm queue\$$1.class
	- rm treemap\$$1.class
=======
	- rm ${JARCLASSES} Manifest
>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1

spotless : clean
	- rm ${JARFILE}

ci : ${SOURCES}
	cid + ${SOURCES}

<<<<<<< HEAD
=======
lis : ${SOURCES}
	mkpspdf ${LISTING} ${SOURCES}

>>>>>>> 7040c7f923b6cda6bd2f93beaf843f415d64d2e1
submit : ${SOURCES}
	submit ${SUBMITDIR} ${SOURCES}

again : 
	gmake --no-print-directory spotless ci all lis

