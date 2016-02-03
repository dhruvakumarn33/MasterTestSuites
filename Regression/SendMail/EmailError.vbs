Dim ToAddress
Dim MessageSubject
Dim MessageBody
Dim MessageAttachment
Dim name

Dim ol, ns, newMail

name= WScript.Arguments.Item(0)
FromAddress = "Venkata.Sanku@charter.com"
ToAddress = "Venkata.Sanku@charter.com"
CcAddress = ""
MessageSubject = "Email Error Alert - "
MessageAttachment = "D:\Regression\null\Email\" & name & ".png"

Set ol = WScript.CreateObject("Outlook.Application")
Set ns = ol.getNamespace("MAPI")
Set newMail = ol.CreateItem(olMailItem)

Set objFileToRead = CreateObject("Scripting.FileSystemObject").OpenTextFile(MessageAttachment, 1)
strFileText = "Hi, Error notification on ATMAIL. Please refer Screenshot."
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
