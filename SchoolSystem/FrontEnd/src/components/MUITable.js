import React, { Component } from 'react'
import StudentService from './services/StudentService'
import { DataGrid } from '@material-ui/data-grid';
import { render } from '@testing-library/react';

const columns = [
  { field: 'id', headerName: 'ID', width: 70 },
  { field: 'firstName', headerName: 'First name', width: 130 },
  { field: 'lastName', headerName: 'Last name', width: 130 },
  {field: 'email',headerName: 'Email',width: 130,},
  {
    field: 'fullName',
    headerName: 'Full name',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 160,
    valueGetter: (params) =>
      `${params.getValue('firstName') || ''} ${params.getValue('lastName') || ''}`,
  },
];



export default class MUITable extends Component {

    constructor(props){
        super(props)

        this.state= {
            students: []
        }

     
    }

    

    componentDidMount(){
        StudentService.getStudents().then((res) =>{
            this.setState({students: res.data });
        });
    }
    render(){

        const rows = this.state.students.map(
            students=> [
                { id: students.id, lastName: students.lastName, firstName: students.firstName, email: students.email },
              ]
        )

       /*
       const rows = [
        { id: 1, lastName: 'Snow', firstName: 'Jon', age: 35 },
        { id: 2, lastName: 'Lannister', firstName: 'Cersei', age: 42 },
        { id: 3, lastName: 'Lannister', firstName: 'Jaime', age: 45 },
        { id: 4, lastName: 'Stark', firstName: 'Arya', age: 16 },
        { id: 5, lastName: 'Targaryen', firstName: 'Daenerys', age: null },
        { id: 6, lastName: 'Melisandre', firstName: null, age: 150 },
        { id: 7, lastName: 'Clifford', firstName: 'Ferrara', age: 44 },
        { id: 8, lastName: 'Frances', firstName: 'Rossini', age: 36 },
        { id: 9, lastName: 'Roxie', firstName: 'Harvey', age: 65 },
      ];
      */
       
    
  return (
    <div style={{ height: 400, width: '100%' }}>
      <DataGrid rows={rows} columns={columns} pageSize={5} checkboxSelection />
    </div>
  );
}
}