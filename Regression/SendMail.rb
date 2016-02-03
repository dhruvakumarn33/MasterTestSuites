require 'net/smtp'

$email_server = 'APACSMTP.CTS.COM'

def send_email(from, from_alias, to, to_alias, subject, message)

msg = <<END_OF_MESSAGE
From: #{from_alias} <#{from}>
To: #{to_alias} <#{to}>
Recipients.Add: 'dhruva.kumar@cognizant.com'
Recipients.Add: ''
Recipients.Add: ''
Subject: #{subject}
MIME-Version: 1.0
Content-type: text/html

#{message}
END_OF_MESSAGE

Net::SMTP.start($email_server) do |smtp|
  smtp.send_message msg, from, to
end
end
#DL-NDS-BAReport
send_email('Lakshmi.Gorantla@cognizant.com', 'Charter Automation Team', 'Sudhakar.Hallur@cognizant.com', 'Charter Test Recipients', 'ITJumpStart Report - Feb 16th 2015 - 1340', File.open('E:\Jenkins_Charter\CharterNet\target\surefire-reports\CharterNet_SeleniumTestReport.html').read)
