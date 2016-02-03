Dim ToAddress
Dim MessageSubject
Dim MessageBody
Dim MessageAttachment

Dim ol, ns, newMail

FromAddress = "dhruva.kumar@cognizant.com"
ToAddress = "VenkataRamana.Sanku@cognizant.com"
CcAddress = "Hemaraju.KV@cognizant.com"
MessageSubject = "Automation Results for Prod Environment"
MessageAttachment = "D:\EngProd_Charter\target\surefire-reports\CharterNet_SeleniumTestReport.html"

Set ol = WScript.CreateObject("Outlook.Application")
Set ns = ol.getNamespace("MAPI")
Set newMail = ol.CreateItem(olMailItem)

Set objFileToRead = CreateObject("Scripting.FileSystemObject").OpenTextFile(MessageAttachment, 1)
strFileText = objFileToRead.ReadAll()
objFileToRead.Close
Set objFileToRead = Nothing

newMail.Subject = MessageSubject & Now
newMail.HTMLBody  = strFileText
newMail.To = ToAddress
newMail.CC = CcAddress
newMail.Display
newMail.Attachments.Add(MessageAttachment).Displayname = "Check this out"
newMail.Send

Set ol = Nothing
