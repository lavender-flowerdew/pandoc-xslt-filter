<?xml version="1.0"?>
<xsl:stylesheet version="2.1"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- XSLT Template to copy anything, priority="-1" -->
  <xsl:template match="@*|node()" priority="-1">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
  </xsl:template>

  <!-- If I were to do something different for an element here is how I'd do it. -->
  <xsl:template match="c[t = 'Str']">
    <c>*</c>
  </xsl:template>

</xsl:stylesheet>
