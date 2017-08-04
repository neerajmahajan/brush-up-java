<H3>Content Negotiation- Request/Response type</H3><br>
 Client specifies what it wants through <b>Accept</b> header.
 Server specifies what is produces through <b>Content-Type</b> header. eg application/json, application/xml, application/pdf
 
 <H3>Rest Api graphical clients</H3>
  <b>Advanced Rest Client</b>, <b>Postman</b> for Chrome
  <b>Poster</b> for Firefox
 
<H3>Rest Api command line clients</H3>
 curl
 eg curl -X POST -u <uerName>:<password> neeraj:1 http://localhost:8080/customers -H "Accept:application/json" -d "...request Body ..."
