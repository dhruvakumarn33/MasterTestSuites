WinWaitActive("","Authentication Required","120")
 If WinExists("","Authentication Required") Then
 Send("charternet{TAB}")
 Send("Chart3rn3t{Enter}")
 EndIf