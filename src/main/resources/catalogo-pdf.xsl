<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.1" 
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
				xmlns:fo="http://www.w3.org/1999/XSL/Format"	
				exclude-result-prefixes="fo">

<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:template match="catalogo">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
	            <fo:simple-page-master master-name="A4"
                                   page-width="210mm" page-height="297mm"
                                   margin-top="1cm" margin-bottom="1cm"
                                   margin-left="1cm" margin-right="1cm">
		          	<fo:region-body/>
    	        	<!-- Page template goes here -->
        	    </fo:simple-page-master>
			</fo:layout-master-set>
			
			<fo:page-sequence master-reference="A4">
            	<!-- Page content goes here -->
	            <fo:flow flow-name="xsl-region-body">
            		<fo:block font-size="10pt">
	               		<xsl:apply-templates select="cd"/>
					</fo:block>	               		
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	
	<xsl:template match="cd">
		<fo:table>
     		<fo:table-column column-width="105mm"/>
		   <fo:table-column column-width="105mm"/>
     		<fo:table-body>
  				<fo:table-row border-bottom="solid">
  					<fo:table-cell>
        				<fo:block color="#FF0000">Titulo</fo:block>
			    	</fo:table-cell>
  					<fo:table-cell>
        				<fo:block color="#FF0000">Artista</fo:block>
			    	</fo:table-cell>
  				</fo:table-row>
  				<fo:table-row>
		     		<xsl:apply-templates select="titulo"/>
		     		<xsl:apply-templates select="artista"/>
  				</fo:table-row>
     		</fo:table-body>
   		</fo:table>
	</xsl:template>

	<xsl:template match="titulo">
		<fo:table-cell>
        	<fo:block><xsl:value-of select="." /></fo:block>
    	</fo:table-cell>
	</xsl:template>

	<xsl:template match="artista">
		<fo:table-cell>
        	<fo:block><xsl:value-of select="." /></fo:block>
    	</fo:table-cell>
	</xsl:template>
</xsl:stylesheet>				
