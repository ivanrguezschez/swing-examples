<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
			    version="1.0">
	<xsl:output method="html" encoding="ISO-8859-1"/>			    
	<xsl:template match="/">
		<html>
			<body>
				<h2>Mi Coleccion de CD's</h2>
				<xsl:apply-templates />
			</body>
		</html>			
	</xsl:template>
	
	<xsl:template match="cd">
		<p>
			<xsl:apply-templates select="titulo"/>
			<xsl:apply-templates select="artista"/>
		</p>
	</xsl:template>

	<xsl:template match="titulo">
		Titulo: <span style="color:#FF0000"><xsl:value-of select="." /></span>
		<br/>
	</xsl:template>
	<xsl:template match="artista">
		Artista: <span style="color:#00FF00"><xsl:value-of select="." /></span>
		<br/>
	</xsl:template>
</xsl:stylesheet>			    