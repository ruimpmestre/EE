#!/bin/sh
# --------------------------------------------------------------------------------------------------------------------
# Project: Exercise 1
# --------------------------------------------------------------------------------------------------------------------
# Company: Equal Experts.
# --------------------------------------------------------------------------------------------------------------------
# 
# This file contains the script for Fizz Buzz Tests 
# 
# -------------------------------------------------------------------------------------------------------------------- 
# $Id$
# --------------------------------------------------------------------------------------------------------------------
#

# define the reference folder pointing to the installation directory
export TEST_HOME=.

#clean
rm -rf $TEST_HOME/bin/*

#compile
javac -cp $TEST_HOME/lib/ -d $TEST_HOME/bin src/com/ee/fizzbuzz/*.java
javac -cp .:$TEST_HOME/bin:$TEST_HOME/lib/* -d $TEST_HOME/bin test/com/ee/fizzbuzz/tests/*.java

#execute
java -cp .:$TEST_HOME/bin:$TEST_HOME/lib/* com.ee.fizzbuzz.tests.FizzBuzzTests