describe('Register spec', () => {
  it('Register successfull', () => {
    cy.visit('/register')

    cy.intercept('POST', '/api/auth/register', {})

    cy.intercept(
      {
        method: 'GET',
        url: '/api/login',
      },
      []).as('login')
    cy.get('input[formControlName=firstName]').type("franck")
    cy.get('input[formControlName=lastName]').type("ned")
    cy.get('input[formControlName=email]').type("franck@gmail.com.com")
    cy.get('input[formControlName=password]').type(`${"password123*"}{enter}{enter}`)
    cy.url().should('include', '/login')
  })
});