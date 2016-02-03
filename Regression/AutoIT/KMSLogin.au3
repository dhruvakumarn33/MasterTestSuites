WinWaitActive("","Authentication Required","120")
If(WinExists("","Authentication Required")) Then
Send("dkumar2{TAB}")
Send("Sep@2015{Enter}")
EndIf
