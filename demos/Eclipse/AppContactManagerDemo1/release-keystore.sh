export JAVA_HOME=/Program Files (x86)/Java/jdk1.7.0_21
cd /adt32/eclipse/workspace/AppContactManagerDemo1
keytool -genkey -v -keystore AppContactManagerDemo1-release.keystore -alias appcontactmanagerdemo1aliaskey -keyalg RSA -keysize 2048 -validity 10000 < /adt32/eclipse/workspace/AppContactManagerDemo1/appcontactmanagerdemo1keytool_input.txt
