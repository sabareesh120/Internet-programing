<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Product List</title>
      </head>
      <body>
        <table border="1">
          <tr bgcolor="#CCCCCC">
            <th>Name</th>
            <th>Price</th>
          </tr>
          <xsl:for-each select="products/product">
            <tr>
              <td><xsl:value-of select="name"/></td>
              <td>
                <xsl:if test="price > 50">
                  <span style="background-color: yellow;"><xsl:value-of select="price"/></span>
                </xsl:if>
                <xsl:if test="price <= 50">
                  <xsl:value-of select="price"/>
                </xsl:if>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
