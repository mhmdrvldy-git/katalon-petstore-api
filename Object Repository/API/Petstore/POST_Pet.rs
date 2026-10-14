<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST_Pet</name>
   <tag></tag>
   <elementGuidId>70ed7ac1-6d60-4d91-9c78-cdc3853d7606</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;\n{\n  \&quot;id\&quot;: ${petId},\n  \&quot;name\&quot;: \&quot;${petName}\&quot;,\n  \&quot;photoUrls\&quot;: [],\n  \&quot;tags\&quot;: [],\n  \&quot;status\&quot;: \&quot;${petStatus}\&quot;\n}\n&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>73cdaf7c-2680-46db-bc7c-789a8d07b8eb</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>11.0.1</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}/pet</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'0'</defaultValue>
      <description></description>
      <id>cfad7a33-1a98-4486-a4c8-efd30254053e</id>
      <masked>false</masked>
      <name>petId</name>
   </variables>
   <variables>
      <defaultValue>'AutoPet'</defaultValue>
      <description></description>
      <id>293c05fc-09cc-42ad-962d-b308df5211a4</id>
      <masked>false</masked>
      <name>petName</name>
   </variables>
   <variables>
      <defaultValue>'available'</defaultValue>
      <description></description>
      <id>16532b7f-f23d-4b22-ac83-555ab656cf9e</id>
      <masked>false</masked>
      <name>petStatus</name>
   </variables>
   <variables>
      <defaultValue>'https://petstore.swagger.io/v2'</defaultValue>
      <description></description>
      <id>17c17df1-fa26-4f4c-b57b-8cfd6dd6592d</id>
      <masked>false</masked>
      <name>baseUrl</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
