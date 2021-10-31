def String projectDir = ''

job('Users API Build') {
	jdk('openjdk-11')

	scm {
		git {
			remote {
				url('https://github.com/juanjordaan/users-api')
			}
			branch('*/master')
		}
	}

	triggers {
		scm('* * * * *')
	}

	steps {
		maven {
			mavenInstallation('maven_3_8_3')
			rootPOM("${projectDir}/pom.xml")
			goals('test')
		}
	}
}
