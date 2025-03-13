describe('Account spec', () => {
    it('Login successfull', () => {
      cy.visit('/login')
  
      cy.intercept('POST', '/api/auth/login', {
        body: {
          id: 1,
          username: 'userName',
          firstName: 'firstName',
          lastName: 'lastName',
          admin: true
        },
      })
  
      cy.intercept(
        {
          method: 'GET',
          url: '/api/session',
        },
        []).as('session')
  
        cy.intercept('GET', '/api/session', {
            body: [
              {
                id: 1,
                name: 'Beginner Session',
                description: 'Course for beginner',
                date: new Date(),
                teacher_id: 1,
                users: [1, 2, 3],
                createdAt: new Date(),
                updatedAt: new Date(),
              },
              {
                id: 2,
                name: 'Intermediate Session',
                description: 'For intermediate level',
                date: new Date(),
                teacher_id: 2,
                users: [4, 5, 6],
                createdAt: new Date(),
                updatedAt: new Date(),
              },
            ],
          }).as('getSessions')
      cy.intercept('GET', '/api/user/1', {
        body: {
          id: 1,
          email: "franck@gmail.com",
          lastName: "Ned",
          firstName: "Franck",
          admin: true,
          password: "password1234**",
          createdAt: new Date(),
          updatedAt: null
        }
      })
      cy.get('input[formControlName=email]').type("yoga@studio.com")
      cy.get('input[formControlName=password]').type(`${"test!1234"}{enter}{enter}`)
      cy.url().should('include', '/sessions')
      cy.wait('@getSessions')
      cy.get('span').contains('Account').click()
      it('Displays User information', () => {
        cy.get('p').should('contain.text', 'Name')
        cy.get('p').should('contain.text', 'Email')
      })
    })
  });