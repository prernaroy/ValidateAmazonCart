<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">

<html>
<head>
<style type="text/css">
	Table{font-family: Verdana; font-size: 10pt;}
</style>
</head>

<body>
<table align="center" border="0" cellpadding="4" cellspacing="0" style="border:0px solid" width="100%">
       <tr>
  
	  <td align="right" valign = "bottom"><img border="0" src="XmlReference/Capture.PNG" /></td>         
       </tr>
</table>

<tr>
<td><hr /></td>
</tr>

<table border="0" width="100%" style="color:003399">
<tr>
<td><h3><font face="Verdana">High Level Report Summary:</font></h3></td>
</tr>	
</table>

<!-- I tried below things -->
<!-- <xsl:for-each select="RootNode/ParentNode/TcId[@distinct='true']"/> -->
<!-- RootNode/ParentNode/TcId[generate-id(.)=generate-id('uTCid',TCId)[1])] -->
<!-- <xsl:variable name="unique-TCids" select="//@TCId[not(. = ../preceding::*/@TCId)]"/> -->

<xsl:variable name="x" select="count(RootNode/ParentNode[normalize-space(Status)='PASS'])"/>
<xsl:variable name="y" select="count(RootNode/ParentNode[normalize-space(Status)='FAIL'])"/>

<xsl:variable name="passwidth" select="$x div ($x+$y) * 100" />
<xsl:variable name="failwidth" select="$y div ($x+$y) * 100" />
<!-- Draw the horizontal bar -->


<table width="45%">
<tr>
<td>

<table border="0" cellpadding="2" cellspacing="2" width="100%" style="border:1px solid">
   <tr><td style="color:003399" width = "50%">Total no. of TestCases Executed </td><td>:</td><td  style="color:003399;font-weight:bold;"><xsl:value-of select="count(RootNode/ParentNode/Status)"/></td></tr>
   <tr><td></td><td></td><td></td></tr>
   <tr><td style="color:003399">Total no. of TestCases Passed</td><td>:</td><td style="color:green; font-weight:bold;"><xsl:value-of select="count(RootNode/ParentNode[normalize-space(Status)='PASS'])"/> </td></tr>
   <tr><td></td><td></td><td></td></tr>
   <tr><td style="color:003399">Total no. of TestCases Failed</td><td>:</td><td style="color:red; font-weight:bold;"><xsl:value-of select="count(RootNode/ParentNode[normalize-space(Status)='FAIL'])"/> </td></tr>
   
   <tr><td></td><td></td><td></td></tr>	
   <tr><td></td><td></td><td></td></tr>	
   <tr><td></td><td></td><td></td></tr>	 
   <tr><td></td><td></td><td></td></tr>	

   <tr><td style="color:003399">Total % of TestCases Passed</td><td>:</td>
       <td align="left">
          <div style="background-color:green;width:{$passwidth}%;text-align:center"><font color="white"><b><xsl:value-of select="format-number($passwidth,'0.0')" />%</b></font></div>
       </td> 
   </tr>    
   <tr><td></td><td></td><td></td></tr>	
	
   <tr><td style="color:003399">Total % of TestCases Failed</td><td>:</td>
       <td align="left">
          <div style="background-color:red;width:{$failwidth}%;text-align:center"><font color="white"><b><xsl:value-of select="format-number($failwidth,'0.0')" />%</b></font> </div>
       </td>
   </tr>     
   <tr><td></td><td></td><td></td></tr>	

   <!-- <tr><td style="color:003399" width = "50%">Total Execution Time </td><td>:</td><td  style="color:003399;font-weight:bold;"><xsl:value-of select="RootNode/@TotalTime"/></td></tr>
   <tr><td></td><td></td><td></td></tr> -->

</table>

</td>

</tr>
</table>

<br/><br/>

<table align="center" border="0" width="100%" style="color:003399">
<tr>
	<td align="left" valign="bottom">
		<h3>
			<font face="Verdana">High Level Report Details:</font>
		</h3>
	</td>
</tr>
<tr>
	<!--<td align="left" valign="bottom">			
		<a target="_top">
			<xsl:attribute name="href">
				<xsl:value-of select="RootNode/@ReportLinkPath"/>
			</xsl:attribute>
			<xsl:attribute name="target">_blank</xsl:attribute>
			<b><font face="Verdana">View Low Level Report</font></b>										
		</a>
	</td>
	--><td align="right" valign="bottom">
		<b>Executed on   :</b>
		<xsl:value-of select="RootNode/@ExecuteTime"/>
	</td>
</tr>
</table>

<table border="0" width="100%" cellpadding="4" cellspacing="1" style="border:1px solid">
   <tr bgcolor="003399">
      <th style="color:white;border:1px solid">S.No</th>
      <th style="color:white;border:1px solid">TestCase ID</th>
	  <th style="color:white;border:1px solid">Description</th>
      <th style="color:white;border:1px solid">Browser</th>
      <th style="color:white;border:1px solid">ScreenShot</th>
      <th style="color:white;border:1px solid">Status</th>
	   <th style="color:white;border:1px solid">Execution Time</th>
	  <th style="color:white;border:1px solid">LowLevelReport</th>
	  <th style="color:white;border:1px solid">Comments</th>	 
    </tr>

   <xsl:for-each select="RootNode/ParentNode">
   <xsl:sort select="TcId"/>   
    <tr style="border:1px solid">
		<td width="5%" align="center" style="border:1px solid"><xsl:value-of select="position()"/></td>      
		<td width="10%" align="center" style="border:1px solid"><xsl:value-of select="TcId" /></td>      
		<td width="20%" align="left" style="border:1px solid"><xsl:value-of select="Description" /></td>   
		<td width="8%" align="center" style="border:1px solid"><xsl:value-of select="Browser" /></td>

		<xsl:choose>
			<xsl:when test="Screenshot =' '">
			<td width="10%" align="center" style="border:1px solid"><xsl:value-of select="Screenshot/@name"/></td>
			</xsl:when>
		<xsl:otherwise>
	    <td width="10%" align="center" style="border:1px solid">
       		<a target="_top">
	  		<xsl:attribute name="href">
				<xsl:value-of select="Screenshot"/>
			</xsl:attribute>
			<xsl:value-of select="Screenshot/@name"/>
			</a>
		</td>
        </xsl:otherwise>        
		</xsl:choose> 

		<xsl:choose>
		<xsl:when test="Status ='PASS'">
           <td width="7%" align="center" style="color:green;border:1px solid"><xsl:value-of select="Status"/></td>
        </xsl:when>
		<xsl:otherwise>
			<td width="7%" align="center" style="color:red;border:1px solid"><xsl:value-of select="Status"/></td> 
        </xsl:otherwise>        
		</xsl:choose>
		<td width="10%" align="center" style="border:1px solid"><xsl:value-of select="Run"/></td>
        <td width="10%" align="center" style="border:1px solid">
			<a target="_top">
	  		<xsl:attribute name="href">
				<xsl:value-of select="LowLevelReport"/>
			</xsl:attribute>
			<xsl:value-of select="LowLevelReport/@name"/>
			</a>
		</td>         
		<td width="20%" align="center" style="border:1px solid"><xsl:value-of select="Comments"/></td> 
	</tr>
   
   </xsl:for-each>
</table>

</body>
</html>
</xsl:template>
</xsl:stylesheet>