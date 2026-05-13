Base URL: /api

STATE HOUSING SUPPORT API

Resource: /states  
Represents: State housing agencies (master table)

1. GET /api/states - Returns a list of all states (summary view).

StateHousingSupportListDTO[]
[
  {
    "id": 1,
    "stateName": "California",
    "agencyName": "California Housing Finance Agency"
  }
]

2. GET /api/states/{id} - Returns full details for a single state.

StateHousingSupportDetailDTO

{
  "id": 1,
  "stateName": "California",
  "agencyName": "California Housing Finance Agency",
  "website": "https://www.calhfa.ca.gov",
  "phone": "800-123-4567"
}

3. POST /api/states - Creates a new state housing agency.

Request Body: StateHousingSupport

{
  "stateName": "Texas",
  "agencyName": "Texas Department of Housing",
  "website": "https://www.tdhca.state.tx.us",
  "phone": "512-475-3800"
}

Response: StateHousingSupportDetailDTO

4. PUT /api/states/{id} - Updates an existing state.

Request Body: StateHousingSupport

{
  "stateName": "Texas",
  "agencyName": "Texas Housing Agency",
  "website": "https://www.tdhca.state.tx.us",
  "phone": "512-475-3800"
}

Response: StateHousingSupportDetailDTO

5. DELETE /api/states/{id} - Deletes a state housing agency.

Response: 204 No Content

---------------------------------------------------
MORTGAGE PROGRAM API
---------------------------------------------------

Resource: /mortgage-programs  
Represents: Mortgage programs offered by state agencies (detail table)

1. GET /api/mortgage-programs - Returns all mortgage programs (summary view).

Response: MortgageProgramListDTO[]

[
  {
    "id": 10,
    "programName": "First-Time Homebuyer Advantage",
    "interestRate": 3.25
  }
]

2. GET /api/mortgage-programs/state/{stateId}

Returns all mortgage programs belonging to a specific state.
Response: MortgageProgramListDTO[]

3. GET /api/mortgage-programs/{id}

Returns full details for a single mortgage program.
Response: MortgageProgramDetailDTO

{
  "id": 10,
  "stateId": 1,
  "stateName": "California",
  "programName": "First-Time Homebuyer Advantage",
  "description": "Low-interest loans for first-time buyers.",
  "interestRate": 3.25,
  "maxLoanAmount": 450000,
  "termYears": 30,
  "active": true
}

4. POST /api/mortgage-programs/state/{stateId}

Creates a mortgage program under a specific state.
Request Body: MortgageProgramDetailDTO (without id/state fields)

{
  "programName": "Down Payment Assistance",
  "description": "Helps with upfront costs.",
  "interestRate": 2.95,
  "maxLoanAmount": 300000,
  "termYears": 15,
  "active": true
}

Response: MortgageProgramDetailDTO

5. PUT /api/mortgage-programs/{id}

Updates a mortgage program.
Request Body: MortgageProgramDetailDTO
Response: MortgageProgramDetailDTO

6. DELETE /api/mortgage-programs/{id}

Deletes a mortgage program.
Response:

204 No Content

--------------------------------------------------
DTO Summary (Quick Reference)
--------------------------------------------------

StateHousingSupportListDTO

id
stateName
agencyName

StateHousingSupportDetailDTO

    id
    stateName
    agencyName
    website
    phone

MortgageProgramListDTO

    id
    programName
    interestRate

MortgageProgramDetailDTO

    id
    stateId
    stateName
    programName
    description
    interestRate
    maxLoanAmount
    termYears
    active

