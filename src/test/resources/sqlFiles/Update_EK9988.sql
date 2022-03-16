declare
              p_FlightNo Varchar(20):='EK9988';
              --p_FlightDt Date:=TO_DATE('31-MAR-2020','DD-MON-YYYY');
              p_FlightDt Date;
              --p_NewFlightDt Date:=TO_DATE('30-MAR-2020','DD-MON-YYYY');
              p_NewFlightDt Date:=trunc(sysdate);
              p_Status  Number;
              p_Message   Varchar2(20);
          
  v_Module    Varchar2(10)  := 'BRSLDTEST' ;
  v_ProcShortName    Varchar2(50)  := 'BRS LOAD TEST' ;

  v_FlightNo    Varchar2(10) ;
  v_FlightDt    Date;
  v_NewFlightDate    Date    :=  Trunc ( Sysdate ) ;
  v_FlightDateDiff  Number;
  v_FlightCount    Number;
  v_NewLine    VARCHAR2(2)  := CHR (13) || CHR (10);
  v_MinBagCount    Number    :=  100;
  v_BagCount    Number;
  v_BaseStation    Varchar2(10)  :=  'DXB' ;
  v_Count      Number;

  Cursor Cur_LTFlights Is
    Select  LTF_FLIGHT_NO FLIGHT_NO , LTF_FLIGHT_DATE FLIGHT_DATE
    From  T_BRS_LOADTEST_FLIGHTS T
    Where  T.LTF_FLIGHT_NO    =  Nvl ( v_FlightNo , T.LTF_FLIGHT_NO )
    And  T.LTF_FLIGHT_DATE  =  Nvl ( v_FlightDt , T.LTF_FLIGHT_DATE );
--    And  T.LTF_FLIGHT_DATE  <>  v_NewFlightDate;

  v_ErrorID    Number;


Begin

  p_Message    :=  '' ;
  p_Status    :=  0 ;

  If p_NewFlightDt Is Null Or Trunc ( p_NewFlightDt ) > Trunc(Sysdate) + 1 Then
    p_Status    :=  1 ;
    p_Message    :=  'Invalid New Flight Date' ;
    RAISE_APPLICATION_ERROR (-20001 , p_Message ) ;
  End If;

  If Nvl ( p_FlightNo , ' ' ) <> ' ' Then
    Begin
      v_FlightNo    :=  Upper ( DPKG_NORMALISE.FLIGHT_NO_VALIDATE(p_FlightNo) ) ;
    Exception
      When Others Then
        p_Status    :=  1 ;
        p_Message    :=  'Unable to Normalize Flight No ' || p_FlightNo || '(' || SQLERRM || ')';
        Raise ;
    End;
    Begin
      SELECT BD.BD_OUTBOUND_FLIGHT_DATE INTO p_FlightDt FROM BAG_DETAIL BD WHERE BD.BD_BM_SEQ_NO='592405708';
      end;
      Dbms_Output.Put_Line ('p_FlightDt:::'|| p_FlightDt);
    If p_FlightDt Is Not Null Then
      v_FlightDt    :=  p_FlightDt ;
      Begin
        Select  Count(1)
        Into  v_Count
        From  T_BRS_LOADTEST_FLIGHTS T
        Where  LTF_FLIGHT_NO    =  v_FlightNo ;
        If Nvl ( v_Count , 0 ) > 0 then
          Update T_BRS_LOADTEST_FLIGHTS Set LTF_FLIGHT_DATE = v_FlightDt Where LTF_FLIGHT_NO = v_FlightNo ;
        Else
          Insert into T_BRS_LOADTEST_FLIGHTS ( LTF_FLIGHT_NO , LTF_FLIGHT_DATE ) Values ( v_FlightNo , v_FlightDt ) ;
        End If;

      Exception
        When Others Then
          p_Status    :=  1 ;
          p_Message    :=  'Unable to update T_BRS_LOADTEST_FLIGHTS Table (' || SQLERRM || ')';
          Raise ;
      End;
    Else
      v_FlightDt    :=  Null ;
    End If;
  Else
    v_FlightNo    :=  Null ;
    v_FlightDt    :=  Null ;
  End If;
  v_FlightCount    :=  0 ;
  v_NewFlightDate    :=  Nvl ( p_NewFlightDt , v_NewFlightDate );
  v_NewFlightDate    :=  Trunc ( v_NewFlightDate ) ;
  For F in Cur_LTFlights Loop
    Select  Count(1)
    Into  v_BagCount
    From  BAG_DETAIL
    WHERE BD_BM_SEQ_NO IN (SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=TRUNC(v_NewFlightDate)) ;
    --If Nvl ( v_BagCount , 0 ) <= Nvl ( v_MinBagCount , 0 ) Then
      Begin
        v_FlightDateDiff  :=  v_NewFlightDate  - TRUNC (  F.FLIGHT_DATE )  ;
        Dbms_Output.Put_Line ( F.FLIGHT_NO || ' / ' || v_FlightDateDiff || ' / ' || TO_CHAR ( SYSDATE + v_FlightDateDiff  , 'DD/MM/YYYY HH24:MI:SS' ) ) ;

        -- BAG_ROUTING

        Update  BAG_ROUTING
        Set  BR_FLIGHT_DATE    =  BR_FLIGHT_DATE + v_FlightDateDiff ,
--          BR_REC_CRT_DATE    =  BR_REC_CRT_DATE + v_FlightDateDiff ,
          BR_REC_UPD_DATE    =  BR_REC_UPD_DATE + v_FlightDateDiff ,
          BR_DEPARTURE_DATE  =  BR_DEPARTURE_DATE + v_FlightDateDiff ,
          BR_ARRIVAL_DATE    =  BR_ARRIVAL_DATE + v_FlightDateDiff
        WHERE BR_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ;
        Dbms_Output.Put_Line ('11');
        -- BAG LOG TRANS
        Delete From BAG_LOG_TRANS L
        WHERE  ( L.BL_BM_SEQ_NO ) IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE)
        AND  L.BL_ULD_NO IS NOT NULL
        AND  BL_STATION_CODE    = v_BaseStation ;
        Dbms_Output.Put_Line ('22');
        Update  BAG_LOG_TRANS L
        Set  BL_LOG_DATE    =  BL_LOG_DATE + v_FlightDateDiff,
          BL_FLIGHT_DATE    =  BL_FLIGHT_DATE + v_FlightDateDiff,
         -- BL_REC_CRT_DATE    =  BL_REC_CRT_DATE + v_FlightDateDiff,
          BL_REC_UPD_DATE    =  BL_REC_UPD_DATE + v_FlightDateDiff
        WHERE   L.BL_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ;
        Dbms_Output.Put_Line ('3');
        -- BAG_EXCEPTIONS
        Update  BAG_EXCEPTIONS E
        Set  /*BE_REC_CREATE_DATE  =   BE_REC_CREATE_DATE + v_FlightDateDiff ,*/
          BE_REC_UPDATE_DATE  =  BE_REC_UPDATE_DATE + v_FlightDateDiff
        WHERE E.BE_BM_SEQ_NO IN (SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ;
        Dbms_Output.Put_Line ('4');
        -- MESSAGE_MASTER
        If v_NewFlightDate < F.FLIGHT_DATE Then

          Update  MESSAGE_MASTER M
          Set  MM_MSG_TEXT    =  REPLACE ( MM_MSG_TEXT , TO_CHAR ( TRUNC (  F.FLIGHT_DATE ) - 2 , 'DDMON' )  , TO_CHAR ( v_NewFlightDate - 2 , 'DDMON' ) )
          WHERE M.MM_MSG_SEQ_NO IN ( SELECT T.BT_MSG_SEQ_NO FROM BAG_TRACKING T WHERE T.BT_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;

          Update  MESSAGE_MASTER M
          Set  MM_MSG_TEXT    =  REPLACE ( MM_MSG_TEXT , TO_CHAR ( TRUNC (  F.FLIGHT_DATE ) - 1 , 'DDMON' )  , TO_CHAR ( v_NewFlightDate - 1 , 'DDMON' ) )
          WHERE M.MM_MSG_SEQ_NO IN ( SELECT T.BT_MSG_SEQ_NO FROM BAG_TRACKING T WHERE T.BT_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;
        Dbms_Output.Put_Line ('5');
          Update  MESSAGE_MASTER M
          Set  MM_RECEIVED_TIMESTAMP  =  MM_RECEIVED_TIMESTAMP + v_FlightDateDiff ,
            MM_PROCESSED_DATE  =  MM_PROCESSED_DATE  + v_FlightDateDiff ,
           -- MM_REC_CRT_DATE    =  MM_REC_CRT_DATE + v_FlightDateDiff ,
            MM_MSG_TEXT    =  REPLACE ( MM_MSG_TEXT , TO_CHAR ( TRUNC (  F.FLIGHT_DATE ) , 'DDMON' )  , TO_CHAR ( v_NewFlightDate , 'DDMON' ) )
          WHERE M.MM_MSG_SEQ_NO IN ( SELECT T.BT_MSG_SEQ_NO FROM BAG_TRACKING T WHERE T.BT_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;
        Dbms_Output.Put_Line ('6');
          Update  MESSAGE_MASTER M
          Set  MM_MSG_TEXT    =  REPLACE ( MM_MSG_TEXT , TO_CHAR ( TRUNC (  F.FLIGHT_DATE ) + 1 , 'DDMON' )  , TO_CHAR ( v_NewFlightDate + 1 , 'DDMON' ) )
          WHERE M.MM_MSG_SEQ_NO IN ( SELECT T.BT_MSG_SEQ_NO FROM BAG_TRACKING T WHERE T.BT_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;

          Update  MESSAGE_MASTER M
          Set  MM_MSG_TEXT    =  REPLACE ( MM_MSG_TEXT , TO_CHAR ( TRUNC (  F.FLIGHT_DATE ) + 2 , 'DDMON' )  , TO_CHAR ( v_NewFlightDate + 2 , 'DDMON' ) )
          WHERE M.MM_MSG_SEQ_NO IN ( SELECT T.BT_MSG_SEQ_NO FROM BAG_TRACKING T WHERE T.BT_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;

        Else

          Update  MESSAGE_MASTER M
          Set  MM_MSG_TEXT    =  REPLACE ( MM_MSG_TEXT , TO_CHAR ( TRUNC (  F.FLIGHT_DATE ) + 2 , 'DDMON' )  , TO_CHAR ( v_NewFlightDate + 2 , 'DDMON' ) )
          WHERE M.MM_MSG_SEQ_NO IN ( SELECT T.BT_MSG_SEQ_NO FROM BAG_TRACKING T WHERE T.BT_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;

          Update  MESSAGE_MASTER M
          Set  MM_MSG_TEXT    =  REPLACE ( MM_MSG_TEXT , TO_CHAR ( TRUNC (  F.FLIGHT_DATE ) + 1 , 'DDMON' )  , TO_CHAR ( v_NewFlightDate + 1 , 'DDMON' ) )
          WHERE M.MM_MSG_SEQ_NO IN ( SELECT T.BT_MSG_SEQ_NO FROM BAG_TRACKING T WHERE T.BT_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;

          Update  MESSAGE_MASTER M
          Set  MM_RECEIVED_TIMESTAMP  =  MM_RECEIVED_TIMESTAMP + v_FlightDateDiff ,
            MM_PROCESSED_DATE  =  MM_PROCESSED_DATE  + v_FlightDateDiff ,
           -- MM_REC_CRT_DATE    =  MM_REC_CRT_DATE + v_FlightDateDiff ,
            MM_MSG_TEXT    =  REPLACE ( MM_MSG_TEXT , TO_CHAR ( TRUNC (  F.FLIGHT_DATE ) , 'DDMON' )  , TO_CHAR ( v_NewFlightDate , 'DDMON' ) )
          WHERE M.MM_MSG_SEQ_NO IN ( SELECT T.BT_MSG_SEQ_NO FROM BAG_TRACKING T WHERE T.BT_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;

          Update  MESSAGE_MASTER M
          Set  MM_MSG_TEXT    =  REPLACE ( MM_MSG_TEXT , TO_CHAR ( TRUNC (  F.FLIGHT_DATE ) - 1 , 'DDMON' )  , TO_CHAR ( v_NewFlightDate - 1 , 'DDMON' ) )
          WHERE M.MM_MSG_SEQ_NO IN ( SELECT T.BT_MSG_SEQ_NO FROM BAG_TRACKING T WHERE T.BT_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;

          Update  MESSAGE_MASTER M
          Set  MM_MSG_TEXT    =  REPLACE ( MM_MSG_TEXT , TO_CHAR ( TRUNC (  F.FLIGHT_DATE ) - 2 , 'DDMON' )  , TO_CHAR ( v_NewFlightDate - 2 , 'DDMON' ) )
          WHERE M.MM_MSG_SEQ_NO IN ( SELECT T.BT_MSG_SEQ_NO FROM BAG_TRACKING T WHERE T.BT_BM_SEQ_NO IN ( SELECT BD_BM_SEQ_NO  FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;

        End If;

        -- BAG_TRACKING
        Update  BAG_TRACKING T
        Set  /*BT_REC_CRT_DATE    =  BT_REC_CRT_DATE  + v_FlightDateDiff ,*/
          BT_REC_UPD_DATE    =  BT_REC_UPD_DATE   + v_FlightDateDiff
        WHERE  T.BT_BM_SEQ_NO     IN ( SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ;

        Dbms_Output.Put_Line ('77');
        -- BAG_INVENTORY
        Update  BAG_INVENTORY I
        Set  BI_LOG_DATE    =  BI_LOG_DATE + v_FlightDateDiff ,
          BI_FLIGHT_DATE    =  BI_FLIGHT_DATE + v_FlightDateDiff ,
          BI_REC_CRT_DATE    =  BI_REC_CRT_DATE + v_FlightDateDiff ,
          BI_REC_UPD_DATE    =  BI_REC_UPD_DATE + v_FlightDateDiff
        WHERE  I.BI_BM_SEQ_NO    IN ( SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE);
        Dbms_Output.Put_Line ('88');
        -- BAGGAGE ALERT
        Update  BAGGAGE_ALERTS A
        Set  BA_FLIGHT_STD    =  BA_FLIGHT_STD + v_FlightDateDiff ,
          BA_FLIGHT_ETD    =  BA_FLIGHT_ETD + v_FlightDateDiff ,
          BA_INBOUND_FLIGHT_DATE  =  BA_INBOUND_FLIGHT_DATE + v_FlightDateDiff ,
          BA_OUTBOUND_FLIGHT_DATE  =  BA_OUTBOUND_FLIGHT_DATE + v_FlightDateDiff ,
          BA_BAG_LAST_SEEN_DATE  =  BA_BAG_LAST_SEEN_DATE + v_FlightDateDiff ,
          BA_ALERT_DATE    =  BA_ALERT_DATE + v_FlightDateDiff ,
          BA_FOLLOWUP_DATE  =  BA_FOLLOWUP_DATE + v_FlightDateDiff ,
          BA_FOLLOWUP_SENT  =  BA_FOLLOWUP_SENT + v_FlightDateDiff ,
          BA_ESCALATION_DATE  =  BA_ESCALATION_DATE + v_FlightDateDiff ,
          BA_ESCALATION_SENT  =  BA_ESCALATION_SENT + v_FlightDateDiff ,
          BA_REC_CREATED_DT  =  BA_REC_CREATED_DT + v_FlightDateDiff ,
          BA_REC_UPDATED_DT  =  BA_REC_UPDATED_DT + v_FlightDateDiff
        WHERE   A.BA_BM_SEQ_NO     IN  (  SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE);
        Dbms_Output.Put_Line ('99');
        -- FLIGHT_ROUTE_SCHEDULE
        --Delete FLIGHT_ROUTE_SCHEDULE R WHERE R.FR_FLIGHT_NO = F.FLIGHT_NO AND TRUNC ( R.FR_FLIGHT_DATE ) = v_NewFlightDate;
        Update  FLIGHT_ROUTE_SCHEDULE R
        Set  FR_FLIGHT_DATE    =  FR_FLIGHT_DATE + v_FlightDateDiff ,
          FR_ARRIVAL_DATE    =  Decode ( TRUNC ( FR_ARRIVAL_DATE ) , NULL , FR_ARRIVAL_DATE , TRUNC ( v_NewFlightDate ) , ( FR_ARRIVAL_DATE + v_FlightDateDiff ) , TRUNC ( v_NewFlightDate ) -1  , ( FR_ARRIVAL_DATE + v_FlightDateDiff ) -1 , TRUNC ( v_NewFlightDate ) -2 , ( FR_ARRIVAL_DATE + v_FlightDateDiff ) -2 , TRUNC ( v_NewFlightDate ) +1 , ( FR_ARRIVAL_DATE + v_FlightDateDiff ) +1 , TRUNC ( v_NewFlightDate ) +2 , ( FR_ARRIVAL_DATE + v_FlightDateDiff ) +2 ,  FR_ARRIVAL_DATE ) ,
          FR_DEPARTURE_DATE  =  Decode ( TRUNC ( FR_DEPARTURE_DATE ) , NULL , FR_DEPARTURE_DATE , TRUNC ( v_NewFlightDate ) , ( FR_DEPARTURE_DATE + v_FlightDateDiff ) , TRUNC ( v_NewFlightDate ) -1  , ( FR_DEPARTURE_DATE + v_FlightDateDiff ) -1 , TRUNC ( v_NewFlightDate ) -2 , ( FR_DEPARTURE_DATE + v_FlightDateDiff ) -2 ,TRUNC ( v_NewFlightDate ) +1 , ( FR_DEPARTURE_DATE + v_FlightDateDiff ) +1 ,TRUNC ( v_NewFlightDate ) +2 , ( FR_DEPARTURE_DATE + v_FlightDateDiff ) +2 , FR_DEPARTURE_DATE ) ,
          FR_REC_CREATE_DATE  =  FR_REC_UPDATE_DATE + v_FlightDateDiff,
          FR_REC_UPDATE_DATE  =  FR_REC_UPDATE_DATE + v_FlightDateDiff
        WHERE R.FR_FLIGHT_NO = F.FLIGHT_NO AND TRUNC ( R.FR_FLIGHT_DATE ) = F.FLIGHT_DATE ;
        Dbms_Output.Put_Line ('10');
        -- FLIGHT_SCHEDULES
        --Delete FLIGHT_SCHEDULES F WHERE F.FS_FLIGHT_NO = F.FLIGHT_NO AND TRUNC ( F.FS_FLIGHT_STA_STD ) = v_NewFlightDate ;
        Update  FLIGHT_SCHEDULES F
        Set  FS_FLIGHT_STA_STD  =  FS_FLIGHT_STA_STD + v_FlightDateDiff ,
          FS_FLIGHT_ETA_ETD  =  FS_FLIGHT_ETA_ETD + v_FlightDateDiff ,
          FS_FLIGHT_ATA_ATD  =  FS_FLIGHT_ATA_ATD + v_FlightDateDiff ,
          FS_REC_CRT_DATE    =  FS_REC_CRT_DATE + v_FlightDateDiff ,
          FS_REC_UPD_DATE    =  FS_REC_UPD_DATE + v_FlightDateDiff ,
          FS_MARS_UPLOAD_DATE  =  FS_MARS_UPLOAD_DATE + v_FlightDateDiff ,
          FS_FLIGHT_STATUS_SYSTEM='FO',
          FS_FLIGHT_STATUS=NULL,
          FS_HOLD_DOOR_CLOSED_AT  =  FS_HOLD_DOOR_CLOSED_AT + v_FlightDateDiff
        WHERE F.FS_FLIGHT_NO = F.FLIGHT_NO AND TRUNC ( F.FS_FLIGHT_STA_STD ) = F.FLIGHT_DATE ;
        Dbms_Output.Put_Line ('111');
        --T_GATE_BAGS_ROUTING
        Update  T_GATE_BAGS_ROUTING GR
        Set  GBR_FLIGHT_DT    =  GBR_FLIGHT_DT + v_FlightDateDiff ,
          GBR_FLIGHT_STD    =  GBR_FLIGHT_STD + v_FlightDateDiff ,
          GBR_REC_CRT_DATE  =  GBR_REC_CRT_DATE + v_FlightDateDiff ,
          GBR_REC_UPD_DATE  =  GBR_REC_UPD_DATE + v_FlightDateDiff
        WHERE GR.GBR_GB_SEQ_NO IN ( SELECT G.GB_SEQ_NO FROM T_GATE_BAGS G WHERE G.GB_BM_SEQ_NO  IN ( SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ) ;
        Dbms_Output.Put_Line ('2222');
        -- T_GATE_BAGS
        Update  T_GATE_BAGS G
        Set  GB_OUTBOUND_FLIGHT_DT  =  GB_OUTBOUND_FLIGHT_DT + v_FlightDateDiff ,
          GB_INBOUND_FLIGHT_DT  =  GB_INBOUND_FLIGHT_DT + v_FlightDateDiff ,
          GB_REC_CRT_DATE    =  GB_REC_CRT_DATE + v_FlightDateDiff ,
          GB_REC_UPD_DATE    =  GB_REC_UPD_DATE + v_FlightDateDiff
        WHERE   G.GB_BM_SEQ_NO     IN   (SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ;
        Dbms_Output.Put_Line ('3333');
        --- BAG_MASTER
        Update  BAG_MASTER
        Set  BM_BAG_DATE    =  BM_BAG_DATE + v_FlightDateDiff ,
          BM_ORG_FLIGHT_DATE  =  BM_ORG_FLIGHT_DATE + v_FlightDateDiff ,
          BM_LAST_SEEN_DATE  =  BM_LAST_SEEN_DATE + v_FlightDateDiff ,
          --BM_REC_CRT_DATE    =  BM_REC_CRT_DATE + v_FlightDateDiff ,
          BM_REC_UPD_DATE    =  BM_REC_UPD_DATE + v_FlightDateDiff,
          BM_STATUS    =  'O'
        WHERE BM_SEQ_NO IN (SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ;
        Dbms_Output.Put_Line ('4444');
        -- T_ULD_ONWARDS
        Update  T_ULD_ONWARDS
        Set  ULO_ONWARD_FLIGHT_DATE  =  ULO_ONWARD_FLIGHT_DATE + v_FlightDateDiff ,
          --ULO_CREATED_DATE  =  ULO_CREATED_DATE + v_FlightDateDiff ,
          ULO_UPDATED_DATE  =  ULO_UPDATED_DATE + v_FlightDateDiff
        Where  ULO_ULD_SEQ_NO IN ( SELECT ULD_SEQ_NO FROM T_ULDS U Where U.ULD_FLIGHT_NO = F.FLIGHT_NO And U.ULD_FLIGHT_DATE = F.FLIGHT_DATE);
        Dbms_Output.Put_Line ('5555');
        --T_ULDS
        Update T_ULDS U
        Set  ULD_FLIGHT_DATE    =  ULD_FLIGHT_DATE   + v_FlightDateDiff ,
          ULD_CREATED_DATE  =  ULD_CREATED_DATE + v_FlightDateDiff ,
          ULD_UPDATED_DATE  =  ULD_UPDATED_DATE + v_FlightDateDiff ,
          ULD_LOAD_SEQ_NO    =  0 ,
          ULD_STATUS    =  'O'
        Where  U.ULD_FLIGHT_NO    =  F.FLIGHT_NO
        And  U.ULD_FLIGHT_DATE  =  F.FLIGHT_DATE ;
        Dbms_Output.Put_Line ('6666');
        -- BAG_DETAIL
        Select  Count(1)
        Into  v_Count
        From  BAG_DETAIL D
        WHERE BD_BM_SEQ_NO IN (SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ;
        Update  BAG_DETAIL D
        Set  BD_INBOUND_FLIGHT_DATE    =  BD_INBOUND_FLIGHT_DATE + v_FlightDateDiff ,
          BD_OUTBOUND_FLIGHT_DATE    =  BD_OUTBOUND_FLIGHT_DATE + v_FlightDateDiff ,
          BD_NEXT_ONWARD_FLIGHT_DATE  =  BD_NEXT_ONWARD_FLIGHT_DATE + v_FlightDateDiff ,
          BD_REC_CRT_DATE      =  BD_REC_CRT_DATE + v_FlightDateDiff ,
          BD_REC_UPD_DATE      =  BD_REC_UPD_DATE + v_FlightDateDiff ,
          BD_LAST_SEEN_DATE    =  BD_LAST_SEEN_DATE + v_FlightDateDiff ,
          BD_ULD_NO      =  NULL ,
          BD_ULD_LOADED_FLAG    =  'N' ,
          BD_ULD_LOADED_DATE_LOCAL  =  NULL,
          BD_ULD_LOADED_LOCATION    =  NULL,
          BD_ULD_SEQ      =  0,
          (BD_BL_SEQ_NO , BD_BL_LOG_DATE ) =  (Select BL_LOG_SEQ_NUM , BL_LOG_DATE FROM BAG_LOG_TRANS WHERE BL_LOG_SEQ_NUM = (Select MAX(BL_LOG_SEQ_NUM) From BAG_LOG_TRANS L WHERE L.BL_BM_SEQ_NO = D.BD_BM_SEQ_NO AND L.BL_BD_SEQ_NO = D.BD_SEQ_NO))
        WHERE BD_BM_SEQ_NO IN (SELECT BD_BM_SEQ_NO FROM BAG_DETAIL D WHERE D.BD_OUTBOUND_FLIGHT_NO=F.FLIGHT_NO AND D.BD_OUTBOUND_FLIGHT_DATE=F.FLIGHT_DATE) ;
        
        Dbms_Output.Put_Line ('7777');
        Update  T_BRS_LOADTEST_FLIGHTS T SET LTF_FLIGHT_DATE = TRUNC ( v_NewFlightDate )
        Where  T.LTF_FLIGHT_NO    =  F.FLIGHT_NO
        And  T.LTF_FLIGHT_DATE  =  F.FLIGHT_DATE ;
 Dbms_Output.Put_Line ('8888');
        v_FlightCount  :=  Nvl ( v_FlightCount , 0 ) + 1 ;
          Dbms_Output.Put_Line ('8999');
        --p_Message  :=  p_Message || 'Flight No ' || F.FLIGHT_NO || ' Date ' || TO_CHAR ( F.FLIGHT_DATE , 'DD/MM/YYYY' ) || ' Data Successfully Converted to '|| To_Char ( v_NewFlightDate , 'DD/MM/YYYY' )  || '('|| To_Char ( v_Count ) || ')' || v_NewLine ;
         Dbms_Output.Put_Line ('8899');
      Exception
        When Others Then
           Dbms_Output.Put_Line ('9999');
          p_Status  :=  1 ;
          p_Message  :=  v_Module || '-'||v_ProcShortName ||': Unable to update BIR Tables' ||  SubStr ( Sqlerrm , 1 , 240);
          Raise ;
      End;
    --Else
    --    p_Message  :=  p_Message || 'Flight No ' || F.FLIGHT_NO || ' Date ' || TO_CHAR ( F.FLIGHT_DATE , 'DD/MM/YYYY' ) || ' : Data already found('|| v_BagCount || ')'  || v_NewLine ;
   -- End If;
  End Loop;

 /* If Nvl ( v_FlightCount , 0 ) <= 0 And Nvl ( p_Message , ' ' ) = ' '  Then
    p_Status    :=  1 ;
    p_Message    :=  'No BRS Load Test Flights Found for Data Conversion' ;
    RAISE_APPLICATION_ERROR (-20001 , p_Message ) ;
  End If;
*/
  Commit;

Exception
  When Others Then
    Rollback;
    If Nvl ( p_Status , 0 ) = 0 Then
      p_Status  :=  SQLCODE ;
      p_Message  :=  v_Module || '-'||v_ProcShortName ||': ' || SubStr ( Sqlerrm , 1 , 240) ;
    End If;
    Begin
      v_ErrorID   :=     Error_Log_Proc( v_Module , p_Status , SubStr ( p_Message , 1 , 250 )  , 'E' , 'DPROC_BRS_MOVE_LOAD_BAG' , 'SYSTEM' , 0 , 0 ) ;
    Exception
      When Others Then
        Dbms_Output.Put_Line ( p_Message || ' / ' ||v_ErrorID ||' and Unable to create Error Log' ) ;
    End ;
End;
