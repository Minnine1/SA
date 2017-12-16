var React = require('react');
var ReactDOM = require('react-dom');
var ons = require('onsenui');
var Ons = require('react-onsenui');
var client = require('./client');
// var jasper = require('node-jasper')(options);
var QRCode = require('qrcode.react');

var JSONDATA = {};

var daycreate = new Date();
var dayex = new Date();
var dd = daycreate.getDate();
var mm = daycreate.getMonth()+1; //January is 0!


var yyyy = daycreate.getFullYear();
var yyyyex = daycreate.getFullYear()+4;
if(dd<10) {
    dd = '0'+dd
}

if(mm<10) {
    mm = '0'+mm
}

daycreate = dd + '-' + mm + '-' + yyyy;

var BroadingPassPage = React.createClass({
    getInitialState: function() {
        return {
            name: JSONDATA.name,
            depart: JSONDATA.depart,
            arrive: JSONDATA.arrive,
            flightNumber: JSONDATA.flightNumber,
            dateandtimeoftravel: JSONDATA.dateandtimeoftravel,
            gate: JSONDATA.gate,
            seat: JSONDATA.seat,
            sequenceNumber: JSONDATA.sequenceNumber

        };
    },



    renderToolbar: function() {
        return (
            <Ons.Toolbar style={{background : '#FFEFEA' }} >
                <div  className='center'>Boarding Pass</div>
                <div className='right'>
                    <Ons.Button style={{background : '#DB3E00' , color: '#FFFFFF'}}  onClick={this.handleSuccess}>Success</Ons.Button>
                </div>
            </Ons.Toolbar>

        );
    },

    handleSuccess: function () {



        ReactDOM.render(<CheckinPage  />, document.getElementById('react'));
    },

    handlePrint: function(){
        window.print();
    },

    handleClick: function() {

        // checkin
        fetch('http://localhost:8080/api/book_tickets')
            .then((response) => response.json())
            .then((responseJson) => {
                // ons.notification.alert('You are now signed in!');
                JSONDATA = responseJson;
                JSONDATA = JSONDATA._embedded;
                // fullname = data.firstName + ' ' + data.lastName;
                console.log("IN BROAD PAGE")
                console.log(data);

            })
            .catch((error) => {
                // ons.notification.alert('Username or password incorrect!');
                // console.error();
                console.log('data not found !!!')
            });


    },


    handleNameChange(e) {
        this.setState({name: e.target.value});
    },

    handleDepartChang(e){
        this.setState({depart: e.target.value});
    },

    handleArriveChange(e) {
        this.setState({arrive : e.target.value});
    },

    handleFlightNumberChange(e){
        this.setState({flightNumber : e.target.value});
    },

    handleDateandtimeoftravel (e){
        this.setState({dateandtimeoftravel : e.target.value});
    },

    handleGateChang(e){
        this.setState({gate: e.target.value});
    },

    handleSeatChange(e) {
        this.setState({seat : e.target.value});
    },

    // handleSequenceNumberChange(e){
    //       this.setState({sequenceNumber: e.target.value});
    // },




    render: function() {
        return (
            <Ons.Page renderToolbar={this.renderToolbar}>
                {/* <div style={{textAlign:'center',paddingTop:'40px'}}> */}
                {/* <Ons.Input value={this.state.QRCode}/> */}
                {/* <QRCode value="https://www.facebook.com/profile/" /><br/> */}
                {/*<h3><a href="https://www.facebook.com/profile/">Your can click link instead scan QRCode</a></h3>*/}
                {/* </div> */}

                <section style={{margin: '16px'}}>
                    <div style={{textAlign:'center',paddingTop:'40px'}}>
                        <QRCode value="https://www.facebook.com/profile/" /><br/>
                        {/* <h3><a href="https://www.facebook.com/profile/">Your can click link instead scan QRCode</a></h3> */}
                    </div>
                    <Ons.Card>
                        <div style={{color: 'lightcoral '}} className="title right">Name</div>
                        <div className="content">
                            <h7 style={{color: 'lightcoral '}}>
                                <Ons.Input value={this.state.name}/>
                            </h7>
                        </div>
                    </Ons.Card>
                    <Ons.Card>
                        <div style={{color: 'lightcoral '}} className="title right">Depart</div>
                        <div className="content">
                            <h7 style={{color: 'lightcoral '}}>
                                <Ons.Input value={this.state.depart}/>
                            </h7>
                        </div>
                    </Ons.Card>
                    <Ons.Card>
                        <div style={{color: 'lightcoral '}} className="title right">Arrive</div>
                        <div className="content">
                            <h7 style={{color: 'lightcoral '}}>
                                <Ons.Input value={this.state.arrive}/>
                            </h7>
                        </div>
                    </Ons.Card>
                    <Ons.Card>
                        <div style={{color: 'lightcoral '}} className="title right">Flight Number</div>
                        <div className="content">
                            <h7 style={{color: 'lightcoral '}}>
                                <Ons.Input value={this.state.flightNumber}/>
                            </h7>
                        </div>
                    </Ons.Card>

                    {/* <Ons.Card>
          <div className="title right">Departure Date</div>
          <div className="content">
          <h7 style={{color: 'lightcoral '}}>
          <Ons.Input value={this.state.depart}/>
          </h7>
          </div>
        </Ons.Card> */}

                    <Ons.Card>
                        <div style={{color: 'lightcoral '}} className="title right">Date and Time Of Travel</div>
                        <div className="content">
                            <h7 style={{color: 'lightcoral '}}>
                                <Ons.Input value={this.state.dateandtimeoftravel}/>
                            </h7>
                        </div>
                    </Ons.Card>

                    <Ons.Card>
                        <div style={{color: 'lightcoral '}}  className="title right">Gate Number</div>
                        <div className="content">
                            <h7 style={{color: 'lightcoral '}}>
                                <Ons.Input value={this.state.gate}/>
                            </h7>
                        </div>
                    </Ons.Card>

                    <Ons.Card>
                        <div style={{color: 'lightcoral '}} className="title right">Seat Number</div>
                        <div className="content">
                            <h7 style={{color: 'lightcoral '}}>
                                <Ons.Input value={this.state.seat}/>
                            </h7>
                        </div>
                    </Ons.Card>

                    <div className='center'>
                        <Ons.Button style={{background : '#DB3E00' , color: '#FFFFFF'}}  onClick={this.handlePrint}>Print</Ons.Button>
                    </div>

                    {/* <Ons.Card>
          <div className="title right">Sequence Number</div>
          <div className="content">
          <h7 style={{color: 'lightcoral '}}>
          54
          </h7>
          </div>
        </Ons.Card> */}
                </section>
            </Ons.Page>
        );
    }
});

var CheckinPage = React.createClass({
    getInitialState: function() {
        return {
            idCustomer: '',
            flightTicket: '',
            Depart:'',
            Arrive:'',
        };
    },

    renderToolbar() {
        return (
            <Ons.Toolbar style={{background : '#FFEFEA' }} >
                <div  className='center'>Moomin Airway</div>
                <div className='right'>
                    <Ons.Button style={{background : '#DB3E00' , color: '#FFFFFF'}}  onClick={this.handleExit}>Exit</Ons.Button>
                </div>
            </Ons.Toolbar>
        );
    },

    handleExit: function () {

        ReactDOM.render(<LoginPage />, document.getElementById('react'));
    },

    handleClick: function() {
        // checkin
        fetch('http://localhost:8080/api/book_tickets/search/findByFlightTicketAndIdCustomer?'+
            'idCustomer=' + this.state.idCustomer + '&flightTicket=' + this.state.flightTicket)
            .then((response)=> response.json())
            .then((responseJson) => {
                ons.notification.alert('You are now signed in!');
                JSONDATA = responseJson;
                // JSONDATA = JSONDATA._embedded;
                // fullname = data.firstName + ' ' + data.lastName;
                console.log("InChecking Page")
                console.log(JSONDATA);
                console.log('-------------------------');
                console.log("kkk" + JSONDATA.save);
                // if(JSONDATA.save == false){
                //     ReactDOM.render(<BroadingPassPage/>, document.getElementById('react'));
                // }
                client({method: 'GET', path:"/cus/"+this.state.idCustomer+"/date/"+daycreate})
                    .done(ReactDOM.render(<BroadingPassPage />, document.getElementById('react')));

            })

            .catch((error) => {
                ons.notification.alert('Username or password incorrect!');
                // console.error();
                console.log('data not found !!!')
            });
        // if (this.state.username === 'admin' && this.state.password === 'admin') {
        //   // ons.notification.alert('You are now signed in!');
        //   ReactDOM.render(<BroadingPassPage />, document.getElementById('react'));
        // }
        // else {
        //   ons.notification.alert('ID Customer or Password Flight ticket incorrect!');
        // }

    },

    handleIdCustomerChange(e) {
        this.setState({idCustomer: e.target.value});
    },

    handleFlightTicketChange(e) {
        this.setState({flightTicket: e.target.value});
    },


    render: function() {
        return (
            <Ons.Page renderToolbar={this.renderToolbar}>
                <section style={{textAlign: 'center'}}>
                    <p>Enter fills below for ckeck your fight</p>
                    <p>
                        <Ons.Input
                            value={this.state.idCustomer}
                            onChange={this.handleIdCustomerChange}
                            modifier='underbar'
                            float
                            placeholder='ID Customer' />
                    </p>
                    <p>
                        <Ons.Input
                            value={this.state.flightTicket}
                            onChange={this.handleFlightTicketChange}
                            modifier='underbar'
                            type='password'
                            float
                            placeholder='Password Flight ticket' />
                    </p>

                    <p>
                        <Ons.Button onClick={this.handleClick}>Check in</Ons.Button>
                    </p>
                </section>
            </Ons.Page>
        );
    }
});


var LoginPage = React.createClass({
    getInitialState: function() {
        return {
            employee_id: '',
            password: ''
        };
    },

    renderToolbar() {
        return (
            <Ons.Toolbar style={{background : '#FFEFEA' }} >
                <div className='center'>Moomin Airway</div>
            </Ons.Toolbar>

        );
    },

    handleClick: function() {
        fetch('http://localhost:8080/api/loginEmployeeCheckins/search/findByEmployeeIDAndPassword?'+
            'employeeID=' + this.state.employee_id + '&password=' + this.state.password)
            .then((response)=> response.json())
            .then((responseJson) => {
                ons.notification.alert('You are now signed in!');
                let data = responseJson;
                // fullname = data.firstName + ' ' + data.lastName;
                console.log(data);

               ReactDOM.render(<CheckinPage />, document.getElementById('react'));




            })
            .catch((error) => {
                ons.notification.alert('Username or password incorrect!');
                // console.error();
                console.log('data not found !!!')
            });
        // if (this.state.username === 'admin' && this.state.password === 'admin') {
        //   ons.notification.alert('You are now signed in!');
        //   ReactDOM.render(<CheckinPage />, document.getElementById('react'));
        // }
        // else {
        //   ons.notification.alert('ไม่พบข้อมูลพนักงาน');
        // }
    },

    handleEmployee_idChange(e) {
        this.setState({employee_id: e.target.value});
        console.log(this.state.employee_id);
    },

    handlePasswordChange(e) {
        this.setState({password: e.target.value});
        console.log(this.state.password);
    },

    handleVegetableChange(vegetable) {
        this.setState({selectedVegetable: vegetable});
    },

    render: function() {
        return (

            <Ons.Page  renderToolbar={this.renderToolbar} >
                <section style={{textAlign: 'center'}}>
                    <h2>เข้าสู่ระบบพนักงาน</h2>
                    <p>
                        <Ons.Input
                            value={this.state.employee_id}
                            onChange={this.handleEmployee_idChange}
                            modifier='underbar'
                            float
                            placeholder='Username' />
                    </p>
                    <p>
                        <Ons.Input
                            value={this.state.password}
                            onChange={this.handlePasswordChange}
                            modifier='underbar'
                            type='password'
                            float
                            placeholder='Password' />
                    </p>
                    <p>
                        <Ons.Button onClick={this.handleClick}>Sign in</Ons.Button>
                    </p>
                </section>

            </Ons.Page>
        );
    }
});

ons.ready(function() {
    ReactDOM.render(<LoginPage />, document.getElementById('react'));
});