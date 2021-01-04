import React, { Component } from 'react'
import StudentService from './services/StudentService';

export default class UpdateById  extends Component {

    constructor(props){
        super(props)

        this.state={
          
            id: this.props.match.params.id, 
            firstName: '',
            lastName: '', 
            email: ''
        }
       
        this.changefirstName = this.changefirstName.bind(this);
        this.changelastName = this.changelastName.bind(this);
        this.changemail = this.changemail.bind(this);
    }

    componentDidMount(){
        StudentService.getStudentById(this.state.id).then((res) =>{
            let student = res.data;
            this.setState({
                firstName: student.firstName,
                lastName: student.lastName,
                email: student.email
            });
        });
    }

    updateStudent= (e) =>{
        e.preventDefault();

        let newStudent = {
            
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email
        }

        let id = this.state.id;

        StudentService.updateStudentById(id, newStudent).then(res =>{
            this.props.history.push('/');
        });

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
                     <button type='submit' onClick={this.updateStudent} className="submit">Submit</button>
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

