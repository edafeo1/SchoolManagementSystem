import React, { Component } from 'react'
import StudentService from './services/StudentService';

export default class UpdateStudent extends Component {

    constructor(props){
        super(props)

        this.state={
          
            firstName: '',
            lastName: '', 
            email: '',
            ID: ''
        }
       
        this.changefirstName = this.changefirstName.bind(this);
        this.changelastName = this.changelastName.bind(this);
        this.changemail = this.changemail.bind(this);
        this.changeID = this.changeID.bind(this);
    }

    saveStudent= (e) =>{
        e.preventDefault();

        let newStudent = {
            
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email
        }
        
        let id = this.state.ID;

        StudentService.updateStudentById(id, newStudent);

        console.log('students => ' + JSON.stringify(newStudent));
    }



    changefirstName= (e) =>{
        this.setState({firstName: e.target.value});
    }

    changelastName= (e) =>{
        this.setState({lastName: e.target.value});
    }

    changemail= (e) =>{
        this.setState({email: e.target.value});
    }

    changeID= (e) => {
        this.setState({ID: e.target.value});
    }

    render() {
    return (

        <section id="contact">

        <div className="row section-head">

           <div className="two columns header-col">

          

           </div>

           <div className="ten columns">


           </div>

        </div>
        <div className="row">
        <div className="eight columns">

                <form id="contactForm" name="contactForm">
					<fieldset>


                  <div>
						   <label htmlFor="contactName">First Name <span className="required">*</span></label>
						   <input value={this.state.firstName} type="text"  size="35" id="contactName" name="contactName" onChange={this.changefirstName}/>
                  </div>

                  <div>
						   <label htmlFor="contactName">Last Name <span className="required">*</span></label>
						   <input value={this.state.lastName} type="text"  size="35" id="contactName" name="contactName" onChange={this.changelastName}/>
                  </div>

                  <div>
						   <label htmlFor="contactEmail">Email <span className="required">*</span></label>
						   <input value={this.state.email } type="text"  size="35" id="contactEmail" name="contactEmail" onChange={this.changemail}/>
                  </div>

                  <div>
						   <label htmlFor="contactEmail">ID <span className="required">*</span></label>
						   <input value={this.state.ID } type="text"  size="35" id="contactEmail" name="contactEmail" onChange={this.changeID}/>
                  </div>

             
                  <div>
                     <button type='submit' onClick={this.saveStudent} className="submit">Submit</button>
                     <span id="image-loader">
                        <img alt="" src='' />
                     </span>
                  </div>
					</fieldset>
				   </form>

       </div>

  </div>
  </section>
    )
}
}

