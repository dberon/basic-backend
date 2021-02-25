package app


import app.security.Role
import app.security.User
import app.security.UserRole

class BootStrap {

    def init = { servletContext ->

        //Security
        User.findByUsername('client') ?: User.withNewTransaction {
            User user = new User(
                    username: 'client',
                    password: 'client',
            )

            user.save(flush: true, failOnError: true)
        }

        Role.findByAuthority('ROLE_CLIENT') ?: Role.withNewTransaction {
            Role role = new Role(authority: 'ROLE_CLIENT')
            role.save(flush: true, failOnError: true)
        }

        UserRole.findByUserAndRole(
                User.findByUsername('client'),
                Role.findByAuthority('ROLE_CLIENT')
        ) ?: UserRole.withNewTransaction {
            UserRole userRole = new UserRole(
                    user: User.findByUsername('client'),
                    role: Role.findByAuthority('ROLE_CLIENT')
            )
            userRole.save(flush: true, failOnError: true)
        }


    }
    def destroy = {
    }
}
