[![Build Status](https://travis-ci.org/lavender-flowerdew/pandoc-xslt-filter.svg?branch=master)](https://travis-ci.org/lavender-flowerdew/pandoc-xslt-filter)
[![Coverage Status](https://coveralls.io/repos/github/lavender-flowerdew/pandoc-xslt-filter/badge.svg?branch=master)](https://coveralls.io/github/lavender-flowerdew/pandoc-xslt-filterbranch=master)

# Pandoc XSLT (2 or 3) Filter

Command line tool intended to be a [Pandoc](http://pandoc.org/) [JSON Filter](https://github.com/jgm/pandoc/wiki/Pandoc-Filters) which converts to XML and processes by running through an XSLT pipeline and then converts back to Pandoc JSON AST. This project is in Java without dependencies on Scala to keep it lightweight, however build and test is Scala (2.12) based. If this mini tool becomes more than a simple
Java wrapper then it will be converted to Scala.

## Building

Run:

`sbt clean jacoco:cover assembly`

## To Do
- [ ] Add xslt library
