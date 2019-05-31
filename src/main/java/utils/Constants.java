package utils;

public class Constants {

	// >>> Logging Priorities
	public static final String C_LOW = "LOW";
	public static final String C_MEDIUM = "MEDIUM";
	public static final String C_HIGH = "HIGH";

	// '>>> Logging Statuses
	public static final String C_PASS = "PASS";
	public static final String C_FAIL = "FAIL";
	public static final String C_NOTRUN = "NOTRUN";
	public static final String C_WARNING = "WARNING";

	// >>> Boolean value:
	public static final String C_TRUE = "TRUE";
	public static final String C_FALSE = "FALSE";
	public static final String C_YES = "YES";
	public static final String C_NO = "NO";
	public static final String C_NULL = "NULL";

	// >>> Not Applicable
	public static final String C_NOTAPPLICABLE = "NA";

	// >>> Space Bar
	public static final String C_SPACE = " ";
	public static final String C_CHECK = "CHECK";
	public static final String C_UNCHECK = "UNCHECK";

	public static final String C_ALERT_ACCEPT = "Accept";
	public static final String C_ALERT_DECLINE = "Decline";
	public static final String C_CLICK = "CLICK";
	public static final String C_TEXT = "TEXT";
	public static final String C_VALUE = "VALUE";

	public static final int C_TCID = 0;
	public static final int C_TCDescription = 2;

	// Constant for file type
	public static final String C_FILETYPE_XLS = "xls";

	// Constant for OS
	public static final String C_OS_WINDOWS_XP = "Windows XP";
	public static final String C_OS_WINDOWS_7 = "Windows 7";

	// Constant for IE Version
	public static final String C_IE7 = "IE7";
	public static final String C_IE8 = "IE8";
	public static final String C_IE9 = "IE9";

	// Constants for testing.properties file
	public static final String C_SHEET_ValidateProfile = "SHEET_ValidateProfile";
	public static final String C_UserName = "UserName";
	public static final String C_Password = "Password";
	
	
	
	
	public static final String C_WB_TESTDATA_MASTERTC = "WB_TestData_MasterTC";
	public static final String C_WB_TESTDATA_TC = "WB_TestData_TC";
	public static final String C_SHEET_MASTER = "SHEET_Master";
	public static final String C_SHEET_PATH = "SHEET_Path";
	public static final String C_SHEET_LOGIN = "SHEET_Login";
	public static final String C_SHEET_LOGOFFTAB = "SHEET_LogOffTab";
	public static final String C_SHEET_NEWFINANCING = "SHEET_NewFinancing";
	public static final String C_SHEET_HEADERDATA = "SHEET_HeaderData";
	public static final String C_SHEET_DETAILS = "SHEET_Details";
	public static final String C_SHEET_CONDITIONS = "SHEET_Conditions";
	public static final String C_SHEET_CONDITIONSHEADER = "SHEET_ConditionsHeader";
	public static final String C_SHEET_COVENANTS = "SHEET_Covenants";
	public static final String C_SHEET_COVENANTSHEADER = "SHEET_CovenantsHeader";
	public static final String C_SHEET_COVENANTSDETAILS = "SHEET_CovenantsDetails";
	public static final String C_SHEET_COVENANTSCC = "SHEET_CovenantsCC";
	public static final String C_SHEET_COVENANTSCC_ADDLOCK = "SHEET_CovenantsCC_AddLock";
	public static final String C_SHEET_DRAWDOWNRULES = "SHEET_DrawDownRules";
	public static final String C_SHEET_REFERENCES = "SHEET_References";
	public static final String C_SHEET_PARTNERS = "SHEET_Partners";
	public static final String C_SHEET_PARTNERS_AddBP = "SHEET_Partners_AddBP";
	public static final String C_SHEET_LOCKS = "SHEET_Locks";
	public static final String C_SHEET_PCR = "SHEET_PayementControlRule";
	public static final String C_SHEET_OverView_Main = "SHEET_OverView_Main";
	public static final String C_SHEET_OverView_Tranche = "SHEET_OverView_Tranche";
	public static final String C_SHEET_NewTranche = "SHEET_NewTranche";
	public static final String C_SHEET_TRACONDITIONS = "SHEET_TraConditions";
	public static final String C_SHEET_TRACONDITIONSHEADER = "SHEET_TraCondition_Header";
	public static final String C_SHEET_TraDrawdown = "SHEET_TraDrawdown";
	public static final String C_SHEET_TRAPARTNERS = "SHEET_TraPartners";
	public static final String C_SHEET_TraAddLock = "SHEET_TraAddLock";
	public static final String C_SHEET_TraAddPaymentControlRule = "SHEET_TraAddPaymentControlRule";
	public static final String C_SHEET_TRASYNDICATION = "SHEET_TraSyndication";
	public static final String C_SHEET_TRASYNDICATIONHEADER = "SHEET_TraSyndicationHeader";
	public static final String C_SHEET_TRASYNDICATIONPARTICIPATION = "SHEET_TraSyndicationParticipation";
	public static final String C_SHEET_TraReferences = "SHEET_TraReferences";
	public static final String C_SHEET_NewDrawdown = "SHEET_NewDrawdown";
	public static final String C_SHEET_EditDraConditions = "SHEET_EditDraConditions";
	public static final String C_SHEET_DraPartners="SHEET_DraPartners";
	public static final String C_SHEET_TraOverview="SHEET_OverView_Tranche";
	public static final String C_SHEET_CREATEDRAWDOWN = "SHEET_CreateDrawDown";
	public static final String C_SHEET_DraCovenants = "SHEET_DraCovenants";
	public static final String C_SHEET_DraCovenantsHeader = "SHEET_DraCovenantsHeader";
	public static final String C_SHEET_DraCovenantsDetails = "SHEET_DraCovenantsDetails";
	public static final String C_SHEET_DraCovenantsCC = "SHEET_DraCovenantsCC";
	public static final String C_SHEET_DraCovenantsCC_AddLock = "SHEET_DraCovenantsCC_AddLock";
	public static final String C_SHEET_DRASYNDICATION = "SHEET_DraSyndication";
	public static final String C_SHEET_DRASYNDICATIONHEADER = "SHEET_DraSyndicationHeader";
	public static final String C_SHEET_DRASYNDICATIONPARTICIPATION = "SHEET_DraSyndicationParticipation";
	public static final String C_SHEET_DRALOCKS = "SHEET_DraLocks";
	public static final String C_SHEET_DRAPCR = "SHEET_DraPayementControlRule";
	public static final String C_SHEET_DraReferences = "SHEET_DraReferences";
	public static final String C_SHEET_ShowCashFlow="SHEET_CashFlow";
	public static final String C_SHEET_SYNDICATION = "SHEET_Syndication";
	public static final String C_SHEET_SYNDICATIONHEADER = "SHEET_SyndicationHeader";
	public static final String C_SHEET_SYNDICATIONPARTICIPATION = "SHEET_SyndicationParticipation";
	public static final String C_SHEET_SEARCHFINANCING = "SHEET_SearchFinancing";
	public static final String C_SHEET_BOOverview = "SHEET_BOOverview";
	public static final String C_SHEET_NewDisbursement = "SHEET_NewDisbursement";
	public static final String C_SHEET_EDITFINANCING = "SHEET_EditFinancing";
	public static final String C_SHEET_EditTranche = "SHEET_EditTranche";
	public static final String C_SHEET_EditDrawdown = "SHEET_EditDrawdown";
	public static final String C_SHEET_TraDetails="SHEET_TraDetails";
	public static final String C_SHEET_BO = "SHEET_BO";
	public static final String C_SHEET_MyInbox = "SHEET_MyInbox"; 
	public static final String C_SHEET_MyInboxReject = "SHEET_MyInboxReject"; 
	public static final String C_SHEET_Copy = "SHEET_Copy";
	public static final String C_SHEET_UFT = "SHEET_UFT";
	public static final String C_SHEET_Waiver = "SHEET_Waiver";
	public static final String C_SHEET_Renewal = "SHEET_Renewal";
	public static final String C_SHEET_Reversal = "SHEET_Reversal";
	public static final String C_SHEET_Withdrawal = "SHEET_Withdrawal";
	public static final String C_SHEET_AddBorrowers = "SHEET_AddBorrowers";
	public static final String C_SHEET_BOChange = "SHEET_BOChange";
	public static final String C_SHEET_Reduction = "SHEET_Reduction";
	public static final String C_SHEET_PAYOFF = "SHEET_Payoff";
	public static final String C_SHEET_DraConditionsDates = "SHEET_DraConditionsDates";
	public static final String C_SHEET_CONDITIONSPAYMENT = "SHEET_ConditionsPayment";
	public static final String C_SHEET_SplitDD="SHEET_SplitDD";
	public static final String C_SHEET_Deferral = "SHEET_Deferral";
	public static final String C_SHEET_WriteOff = "SHEET_WriteOff";
	public static final String C_SHEET_ShareSellP = "SHEET_ShareSellP";
	public static final String C_SHEET_ShareSellA = "SHEET_ShareSellA";
	public static final String C_SHEET_SharePurchase = "SHEET_SharePurchase";
	public static final String C_SHEET_ShareSwap = "SHEET_ShareSwap";
	public static final String C_SHEET_ValidateAmount = "SHEET_ValidateAmount";
	public static final String C_SHEET_EditRules= "SHEET_EditRules";
	
	// Header column names for master test data
	public static final String C_TCID_TEXT = "TCID";
	public static final String C_Agreement = "Agreement";
	public static final String C_EXECUTE_TEST_TEXT = "Execute Test";
	public static final String C_DESCRIPTION_TEXT = "Description";
	public static final String C_EXECUTION_STATUS_TEXT = "Execution Status";

	// Header column names for sheets other than master
	public static final String C_ITERATION1 = "Iteration1";
	public static final String C_ITERATION2 = "Iteration2";
	public static final String C_ITERATION3 = "Iteration3";

	// row and column
	public static final String C_COLUMN = "Column";
	public static final String C_ROW = "Row";

	// operations
	public static final String C_CREATE = "Create";
	public static final String C_VIEW = "View";
	public static final String C_EDIT = "Edit";
	public static final String C_DELETE = "Delete";
	public static final String C_SAVE = "Save";
	public static final String C_CANCEL = "Cancel";
	public static final String C_SPLIT_COMMA = "Comma";
	public static final String C_SPLIT_SEMICOLON = "SemiColon";
	public static final String C_SPLIT_COLON = "Colon";
	public static final String C_SPLIT_SPACE = "Space";
	public static final String C_SPLIT_DOT = "Dot";
	public static final String C_SPLIT_OPENING_PARENTHESES = "Opening_Parentheses";

	// *************** Header column names for test data file *****************

	// Login sheet
	public static final String C_LOGIN_UserName = "UserName";
	public static final String C_LOGIN_Password = "Password";
	public static final String C_LOGIN_IsLogin = "IsLogin";
	public static final String C_LOGIN_Tile = "Tile";
	public static final String C_LOGIN_HeaderLink = "HeaderLink";

	// Log-off sheet
	public static final String C_LogOff_LogOff = "LogOff";

	// NewFinancing sheet
	public static final String C_NEWFINANCING_TOE = "TypeofEntry";
	public static final String C_NEWFINANCING_Product = "Product";
	public static final String C_NEWFINANCING_Name = "Name";
	public static final String C_NEWFINANCING_Description = "Description";
	public static final String C_NEWFINANCING_MainBorrower = "MainBorrower";
	public static final String C_NEWFINANCING_BorrowerName = "BorrowerName";
	public static final String C_NEWFINANCING_TotalFinancingAmt = "TotalFinancingAmt";
	public static final String C_NEWFINANCING_Currency = "Currency";
	public static final String C_NEWFINANCING_Status = "Status";
	public static final String C_NEWFINANCING_StartOfContractTerm = "StartOfContractTerm";
	public static final String C_NEWFINANCING_ECDRPDWN = "ECTerm";
	public static final String C_NEWFINANCING_EndOfContractTerm = "EndOfContractTerm";
	public static final String C_NEWFINANCING_ApprovalDate = "ApprovalDate";
	public static final String C_NEWFINANCING_CommitmentDate = "CommitmentDate";
	public static final String C_NEWFINANCING_ContractConclDate = "ContractConclDate";
	public static final String C_NEWFINANCING_BC = "BankCalendar";
	public static final String C_NEWFINANCING_Create = "Create";
	public static final String C_NEWFINANCING_Syndication = "Syndication";

	// Edit Financing Sheet
	public static final String C_EDITFINANCING_Edit = "Edit";
	public static final String C_EDITFINANCING_Warning = "Warning";


	// Search Financing sheet
	public static final String C_SEARCHFINANCING_Name = "Name";
	public static final String C_SEARCHFINANCING_ReleaseStatus = "ReleaseStatus";
	public static final String C_SEARCHFINANCING_Search = "Go";

	// Overview Disbursement Sheet
	public static final String C_OverviewDisbursement_Name = "Name";
	public static final String C_OverviewDisbursement_Level = "Level";
	public static final String C_OverviewDisbursement_BOType = "BOType";
	public static final String C_OverviewDisbursement_DisabledBO="DisabledBO";

	// New Disbursement Sheet
	public static final String C_NewDisb_Title = "Title";
	public static final String C_NewDisb_Imm_Posting = "Imm_Posting";
	public static final String C_NewDisb_FlowType = "FlowType";
	public static final String C_NewDisb_PaymentDate = "PaymentDate";
	public static final String C_NewDisb_PostingDate = "PostingDate";
	public static final String C_NewDisb_CalculationDate = "CalculationDate";
	public static final String C_NewDisb_WithHoldUpto = "WithHoldUpto";
	public static final String C_NewDisb_Type = "Type";
	public static final String C_NewDisb_Settlement_Amount = "Settlement_Amount";
	public static final String C_NewDisb_Item_Text = "Item_Text";
	public static final String C_NewDisb_Save = "Save";
	public static final String C_NewDisb_Submit = "Submit";
	public static final String C_NewDisb_Deletion="Deletion";
	public static final String C_NewDisb_Reversal="Reversal";
	public static final String C_NewDisb_IC_Withold="IC_Withold";

	// New Waiver Sheet
	public static final String C_NewWaiver_Title = "Title";
	public static final String C_NewWaiver_Imm_Posting = "Posting_Type";
	public static final String C_NewWaiver_FlowType = "FlowType";
	public static final String C_NewWaiver_BO_Text = "BO_Text";
	public static final String C_NewWaiver_WaivedAmt = "WaivedAmount";
	public static final String C_NewWaiver_WaivedStatus = "WaivedStatus";
	public static final String C_NewWaiver_PaymentDate="PaymentDate";
	public static final String C_NewWaiver_Save = "Save";
	public static final String C_NewWaiver_Submit = "Submit";
	public static final String C_NewWaiver_Delete = "Delete";

	// Reversal
	public static final String C_Reversal_Title = "Title";
	public static final String C_Reversal_FromDate = "FromDate";
	public static final String C_Reversal_ToDate = "ToDate";
	public static final String C_Reversal_Text = "Text";
	public static final String C_Reversal_ReasonForReversal= "ReasonForReversal";

	// Renewal
	public static final String C_Renewal_Title = "Title";
	public static final String C_Renewal_Type = "Type";
	public static final String C_Renewal_OfferUntil = "OfferUntil";
	public static final String C_Renewal_FixedUntil = "FixedUntil";
	public static final String C_Renewal_Submit= "Submit";	

	//Withdrawal

	public static final String C_Withdrwal_Title = "Title";
	public static final String C_Withdrwal_CalculationDate = "CalculationDate";
	public static final String C_Withdrwal_NonAcceptance="NonAcceptance";
	public static final String C_Withdrwal_Submit="Submit";
	public static final String C_Withdrwal_VBO="Verify_BO";


	// HeaderData Sheet
	public static final String C_HEADERDATA_Name = "Name";
	public static final String C_HEADERDATA_ExpiryDate = "ExpiryDate";

	// Details
	public static final String C_DETAILS_LANG = "Langauge";
	public static final String C_DETAILS_Syndication = "Syndication";

	//Tranche Details
	public static final String C_TRADETAILS_Start_Of_Term="Start_Of_Term";
	public static final String C_TRADETAILS_Expiry_Date="Expiry_Date";
	public static final String C_TRADETAILS_Revolving="Revolving";
	public static final String C_TRADETAILS_Limit_Crediting="Limit_Crediting";
	// Conditions
	public static final String C_CONDITIONS_Add = "AddConditions";
	public static final String C_CONDITIONS_Remove = "RemoveConditions";
	// Condition Header
	public static final String C_CONDITIONSHEADER_ConditionType = "ConditionType";
	public static final String C_CONDITIONSHEADER_ValidFrom = "ValidFrom";
	public static final String C_CONDITIONSHEADER_Percentage = "Percentage";
	public static final String C_CONDITIONSHEADER_ConditionAmount = "ConditionAmount";
	public static final String C_CONDITIONSHEADER_Skim = "Skim";
	public static final String C_CONDITIONSHEADER_ConditionFrom = "ConditionFrom";
	public static final String C_CONDITIONSHEADER_Payer = "Payer";
	public static final String C_CONDITIONSHEADER_PayerName = "PayerName";
	public static final String C_CONDITIONSHEADER_PeriodicityProfile = "PeriodicityProfile";
	public static final String C_CONDITIONSHEADER_CalculationDate = "CalculationDate";
	public static final String C_CONDITIONSHEADER_DueDate = "DueDate";
	public static final String C_CONDITIONSHEADER_MonitoringLatestOn = "MonitoringLatestOn";
	public static final String C_CONDITIONSHEADER_EarliestExerciseDate = "EarliestExerciseDate";
	public static final String C_CONDITIONSHEADER_LatestExerciseDate = "LatestExerciseDate";
	public static final String C_CONDITIONSHEADER_FreeText = "FreeText";
	public static final String C_CONDITIONSHEADER_Exerised = "Exerised";
	public static final String C_CONDITIONSHEADER_Apply= "Apply";
	//Traconditions
	public static final String C_TRACONDITIONSHEADER_ConditionType = "ConditionType";
	public static final String C_TRACONDITIONSHEADER_ValidFrom = "ValidFrom";
	public static final String C_TRACONDITIONSHEADER_Percentage = "Percentage";
	public static final String C_TRACONDITIONSHEADER_ConditionAmount = "ConditionAmount";
	public static final String C_TRACONDITIONSHEADER_Skim = "Skim";
	public static final String C_TRACONDITIONSHEADER_ConditionFrom = "ConditionFrom";
	public static final String C_TRACONDITIONSHEADER_Payer = "Payer";
	public static final String C_TRACONDITIONSHEADER_PayerName = "PayerName";
	public static final String C_TRACONDITIONSHEADER_PeriodicityProfile = "PeriodicityProfile";
	public static final String C_TRACONDITIONSHEADER_CalculationDate = "CalculationDate";
	public static final String C_TRACONDITIONSHEADER_DueDate = "DueDate";
	public static final String C_TRACONDITIONSHEADER_MonitoringLatestOn = "MonitoringLatestOn";
	public static final String C_TRACONDITIONSHEADER_EarliestExerciseDate = "EarliestExerciseDate";
	public static final String C_TRACONDITIONSHEADER_LatestExerciseDate = "LatestExerciseDate";
	public static final String C_TRACONDITIONSHEADER_FreeText = "FreeText";
	public static final String C_TRACONDITIONSHEADER_Exerised = "Exerised";

	// Covenants
	public static final String C_COVENANTS_Add = "AddCovenants";

	// Covenants Header
	public static final String C_COVENANTSHEADER_TYPE = "CovenantType";
	public static final String C_COVENANTSHEADER_Description = "Description";
	public static final String C_COVENANTSHEADER_EOC_Consequences = "EOC_Consequences";
	public static final String C_COVENANTSHEADER_ValidFrom = "ValidFrom";
	public static final String C_COVENANTSHEADER_ValidTo = "ValidTo";
	public static final String C_COVENANTSHEADER_Date = "Date";

	// Covenants Details
	public static final String C_COVENANTSDETAILS_ResultSupplier = "ResultSupplier";
	public static final String C_COVENANTSDETAILS_CheckProcedure = "CheckProcedure";
	public static final String C_COVENANTSDETAILS_SoftThreshold = "SoftThreshold";
	public static final String C_COVENANTSDETAILS_HardThreshold = "HardThreshold";
	public static final String C_COVENANTSDETAILS_FirstKeyDate = "FirstKeyDate";
	public static final String C_COVENANTSDETAILS_MonitoringProcedure = "MonitoringProcedure";
	public static final String C_COVENANTSDETAILS_CalculationPeriod = "CalculationPeriod";
	public static final String C_COVENANTSDETAILS_PeriodType1 = "PeriodType1";
	public static final String C_COVENANTSDETAILS_SubmissionDeadline = "SubmissionDeadline";
	public static final String C_COVENANTSDETAILS_PeriodType2 = "PeriodType2";

	// CovenantsCC
	public static final String C_COVENANTSCC_Add = "AddCC";

	// CovenantsCC Add Lock
	public static final String C_COVENANTSCCADDLOCK_Type = "Type";
	public static final String C_COVENANTSCCADDLOCK_Usage = "Usage";
	public static final String C_COVENANTSCCADDLOCK_ObligatoryConsequence = "ObligatoryConsequence";
	public static final String C_COVENANTSCCADDLOCK_LockType = "LockType";
	public static final String C_COVENANTSCCADDLOCK_IndividualLock = "IndividualLock";
	public static final String C_COVENANTSCCADDLOCK_CollectiveLock = "CollectiveLock";
	public static final String C_COVENANTSCCADDLOCK_ValidFrom = "ValidFrom";
	public static final String C_COVENANTSCCADDLOCK_Term = "Term";
	public static final String C_COVENANTSCCADDLOCK_ICA_FLAG = "ICA_FLAG";
	public static final String C_COVENANTSCCADDLOCK_CreateCovenant = "CreateCovenant";

	// DrawDownRules Sheet
	public static final String C_DRAWDOWNRULES_Name = "Name";
	public static final String C_DRAWDOWNRULES_ForFinancing = "ForFinancing";
	public static final String C_DRAWDOWNRULES_ForTranche = "ForTranche";
	public static final String C_DRAWDOWNRULES_ForDrawDown = "ForDrawDown";
	public static final String C_DRAWDOWNRULES_MinAmtPerDD = "MinAmtPerDD";
	public static final String C_DRAWDOWNRULES_MinAmtPerDDVal = "MinAmtPerDDVal";
	public static final String C_DRAWDOWNRULES_MaxAmtPerDD = "MaxAmtPerDD";
	public static final String C_DRAWDOWNRULES_MaxAmtPerDDVal = "MaxAmtPerDDVal";
	public static final String C_DRAWDOWNRULES_MultipleOf = "MultipleOf";
	public static final String C_DRAWDOWNRULES_MultipleOfVal = "MultipleOfVal";
	public static final String C_DRAWDOWNRULES_PermAllProd = "PermAllProd";
	public static final String C_DRAWDOWNRULES_PermAllCurr = "PermAllCurr";
	public static final String C_DRAWDOWNRULES_PermIntPeriod = "PermIntPeriod";
	public static final String C_DRAWDOWNRULES_CURRENCY = "Currency";
	public static final String C_DRAWDOWNRULES_FreeTextRule = "FreeTextRule";
	public static final String C_DRAWDOWNRULES_FreeText = "FreeText";
	public static final String C_DRAWDOWNRULES_ValidFrom = "ValidFrom";
	public static final String C_DRAWDOWNRULES_ValidTo = "ValidTo";

	// Reference

	public static final String C_REFERENCES_RefType = "Reference_Type";
	public static final String C_REFERENCES_Refnumber = "Refnumber";
	public static final String C_REFERENCES_URL = "URL";
	public static final String C_REFERENCES_Name = "Name";
	public static final String C_REFERENCES_From = "From";
	public static final String C_REFERENCES_To = "To";

	// Partners Sheet
	public static final String C_PARTNERS_Edit_SyndicateManager = "Edit_SyndicateManager";
	public static final String C_PARTNERS_Edit_MainLoanPartner = "Edit_MainLoanPartner";
	public static final String C_PARTNERS_Edit_AltPayer ="Edit_AltPayer";
	public static final String C_PARTNERS_Edit_AltPayee ="Edit_AltPayee";
	public static final String C_PARTNERS_Edit = "Edit";
	public static final String C_PARTNERS_Title = "Title";
	public static final String C_PARTNERS_SelectBussPartner = "SelectBussPartner";
	public static final String C_PARTNERS_PaymentMethod = "PaymentMethod";
	public static final String C_PARTNERS_BankDetailsID = "BankDetailsID";
	public static final String C_PARTNERS_MandateRef = "MandateRef";
	public static final String C_PARTNERS_AddResponsibleAgent = "AddResponsibleAgent";
	public static final String C_PARTNERS_AgentRole = "AgentRole";
	public static final String C_PARTNERS_ResponsibleAgent = "ResponsibleAgent";
	public static final String C_PARTNERS_OrgUnit = "OrgUnit";
	public static final String C_PARTNERS_ValidFrom = "ValidFrom";
	public static final String C_PARTNERS_UtilizationType = "UtilizationType";
	public static final String C_PARTNERS_ClickSave = "ClickSave";
	public static final String C_PARTNERS_CheckConsistency = "CheckConsistency";
	public static final String C_PARTNERS_CheckConsistErrorMsg = "CheckConsistErrorMsg";
	public static final String C_PARTNERS_ReCheckConsist = "ReCheckConsist";
	public static final String C_PARTNERS_BPID = "BPID";
	public static final String C_PARTNERS_DL = "DL";
	public static final String C_PARTNERS_Syndication = "Syndication";

	public static final String C_PARTNERS_ReClickClose = "ReClickClose";
	public static final String C_PARTNERS_ReleaseStatus = "ReleaseStatus";

	// Partners_AddBP Sheet
	public static final String C_PARTNERS_AddBP_Add = "Add";
	public static final String C_PARTNERS_AddBP_Title = "Title";
	public static final String C_PARTNERS_AddBP_SelectBussPartner = "SelectBussPartner";
	public static final String C_PARTNERS_AddBP_BPRole = "BPRole";
	public static final String C_PARTNERS_AddBP_BPName = "BPName";
	public static final String C_PARTNERS_AddBP_ValidFrom = "ValidFrom";
	public static final String C_PARTNERS_AddBP_ValidTo = "ValidTo";
	public static final String C_PARTNERS_AddBP_PaymentMethod = "PaymentMethod";
	public static final String C_PARTNERS_AddBP_BankDetailsID = "BankDetailsID";
	public static final String C_PARTNERS_AddBP_MandateRef = "MandateRef";
	public static final String C_PARTNERS_AddBP_AddResponsibleAgent = "AddResponsibleAgent";
	public static final String C_PARTNERS_AddBP_AgentRole = "AgentRole";
	public static final String C_PARTNERS_AddBP_ResponsibleAgent = "ResponsibleAgent";
	public static final String C_PARTNERS_AddBP_OrgUnit = "OrgUnit";
	public static final String C_PARTNERS_AddBP_UtilizationType = "UtilizationType";
	public static final String C_PARTNERS_AddBP_ClickSave = "ClickSave";
	public static final String C_PARTNERS_AddBP_CheckConsistency = "CheckConsistency";
	public static final String C_PARTNERS_AddBP_CheckConsistErrorMsg = "CheckConsistErrorMsg";
	public static final String C_PARTNERS_AddBP_ReCheckConsist = "ReCheckConsist";
	public static final String C_PARTNERS_AddBP_ReClickClose = "ReClickClose";
	public static final String C_PARTNERS_AddBP_ReleaseStatus = "ReleaseStatus";

	// Syndication
	public static final String C_SYNDICATION_Title = "Title";
	public static final String C_SYNDICATION_Role = "Role";
	public static final String C_SYNDICATION_MandatorySyndication = "MandatorySyndication";
	public static final String C_SYNDICATION_Value = "Value";
	public static final String C_SYNDICATION_UnderwritingTerm = "UnderwritingTerm";


	// Syndication header
	public static final String C_SYNDICATIONHEADER_Add = "Add";
	public static final String C_SYNDICATIONHEADER_BussPartner = "BussPartner";
	public static final String C_SYNDICATIONHEADER_BussPartnerName = "BussPartnerName";
	public static final String C_SYNDICATIONHEADER_ParticipationVia = "ParticipationVia";
	public static final String C_SYNDICATIONHEADER_ValidFrom = "ValidFrom";
	public static final String C_SYNDICATIONHEADER_ValidTo = "ValidTo";
	public static final String C_SYNDICATIONHEADER_BankDetails = "BankDetails";
	public static final String C_SYNDICATIONHEADER_InPaymentMethod = "InPaymentMethod";
	public static final String C_SYNDICATIONHEADER_OutPaymentMethod = "OutPaymentMethod";
	public static final String C_SYNDICATIONHEADER_ParticipationType = "ParticipationType";
	public static final String C_SYNDICATIONHEADER_Skim = "Skim";

	// Syndication Participation
	public static final String C_SYNDICATIONPARTICIPATION_FinRatio = "FinanceRatio";
	public static final String C_SYNDICATIONPARTICIPATION_FinAmount = "FinanceAmount";
	public static final String C_SYNDICATIONPARTICIPATION_FinPptForm = "FinanceParticipationForm";
	public static final String C_SYNDICATIONPARTICIPATION_TraRatio = "TraRatio";
	public static final String C_SYNDICATIONPARTICIPATION_TraAmount = "TraAmount";
	public static final String C_SYNDICATIONPARTICIPATION_TraPptForm = "TraParticipationForm";
	public static final String C_SYNDICATIONPARTICIPATION_DraRatio = "DraRatio";
	public static final String C_SYNDICATIONPARTICIPATION_DraAmount = "DraAmount";
	public static final String C_SYNDICATIONPARTICIPATION_DraPptForm = "DraParticipationForm";
	public static final String C_SYNDICATIONPARTICIPATION_AddRatio = "AddRatio";

	// Locks
	public static final String C_LOCKS_Add = "AddLocks";
	public static final String C_LOCKS_LockType = "LockType";
	public static final String C_LOCKS_ValidFrom = "ValidFrom";
	public static final String C_LOCKS_ValidTo = "ValidTo";
	public static final String C_LOCKS_ExemptionAmount = "ExemptionAmount";

	// Payment Control Rule
	public static final String C_PCRULE_Add = "AddPCRule";
	public static final String C_PCRULE_Use = "Use";
	public static final String C_PCRULE_ValidFrom = "ValidFrom";
	public static final String C_PCRULE_ValidTo = "ValidTo";
	public static final String C_PCRULE_PayerPayee = "PayerPayee";
	public static final String C_PCRULE_PaymentMethod = "PaymentMethod";
	public static final String C_PCRULE_BankDetails = "BankDetails";

	// Overview Sheet
	public static final String C_OVERVIEW_ClickOverview = "ClickOverview";
	public static final String C_OVERVIEW_Name = "Name";
	public static final String C_OVERVIEW_CreateTranche = "CreateTranche";
	public static final String C_OVERVIEW_CreateDrawdown = "CreateDrawdown";

	// CreateTranche Sheet
	public static final String C_CREATETRANCHE_TranchName = "TranchName";
	public static final String C_CREATETRANCHE_MainBorrower = "MainBorrower";
	public static final String C_CREATETRANCHE_TrancheProduct = "TrancheProduct";
	public static final String C_CREATETRANCHE_TrancheAmt = "TrancheAmt";
	public static final String C_CREATETRANCHE_TrancheCurr = "TrancheCurr";
	public static final String C_CREATETRANCHE_StartofTerm = "StartofTerm";
	public static final String C_CREATETRANCHE_EndofTerm = "EndofTerm";
	public static final String C_CREATETRANCHE_EndDate = "EndDate";
	public static final String C_CREATETRANCHE_ClickCreateEdit = "ClickCreateEdit";

	// Tranche Conditions
	public static final String C_TRANCHECONDITIONS_Add = "AddTrancheConditions";

	// Edit Tranche Sheet
	public static final String C_EditTranche_Edit = "Edit";
	public static final String C_EditTranche_Warning = "Warning";
	public static final String C_EditTranche_TranchName = "TranchName";

	// Edit Drawdown Sheet
	public static final String C_EditDrawdown_Edit = "Edit";
	public static final String C_EditDrawdown_Warning = "Warning";
	public static final String C_EditDrawdown_Level = "Level";

	// Tranche DrawDownRules Sheet
	public static final String C_TRADRAWDOWNRULES_Edit = "Edit";
	public static final String C_TRADRAWDOWNRULES_Name = "Name";
	public static final String C_TRADRAWDOWNRULES_ForFinancing = "ForFinancing";
	public static final String C_TRADRAWDOWNRULES_ForTranche = "ForTranche";
	public static final String C_TRADRAWDOWNRULES_ForDrawDown = "ForDrawDown";
	public static final String C_TRADRAWDOWNRULES_MinAmtPerDD = "MinAmtPerDD";
	public static final String C_TRADRAWDOWNRULES_MinAmtPerDDVal = "MinAmtPerDDVal";
	public static final String C_TRADRAWDOWNRULES_MaxAmtPerDD = "MaxAmtPerDD";
	public static final String C_TRADRAWDOWNRULES_MaxAmtPerDDVal = "MaxAmtPerDDVal";
	public static final String C_TRADRAWDOWNRULES_MultipleOf = "MultipleOf";
	public static final String C_TRADRAWDOWNRULES_MultipleOfVal = "MultipleOfVal";
	public static final String C_TRADRAWDOWNRULES_PermAllProd = "PermAllProd";
	public static final String C_TRADRAWDOWNRULES_PermAllCurr = "PermAllCurr";
	public static final String C_TRADRAWDOWNRULES_PermIntPeriod = "PermIntPeriod";
	public static final String C_TRADRAWDOWNRULES_CURRENCY = "Currency";
	public static final String C_TRADRAWDOWNRULES_FreeTextRule = "FreeTextRule";
	public static final String C_TRADRAWDOWNRULES_FreeText = "FreeText";
	public static final String C_TRADRAWDOWNRULES_ValidFrom = "ValidFrom";
	public static final String C_TRADRAWDOWNRULES_ValidTo = "ValidTo";
	public static final String C_TRADRAWDOWNRULES_MaxDDNumFlag = "MaxDDNumFlag";
	public static final String C_TRADRAWDOWNRULES_MaxDDRestrictedFlag = "MaxDDRestrictedFlag";
	public static final String C_TRADRAWDOWNRULES_MaxDD = "MaxDD";

	// Tranche Syndication
	public static final String C_TRASYNDICATION_Title = "Title";
	public static final String C_TRASYNDICATION_Role = "Role";
	public static final String C_TRASYNDICATION_MandatorySyndication = "MandatorySyndication";
	public static final String C_TRASYNDICATION_Value = "Value";
	public static final String C_TRASYNDICATION_UnderwritingTerm = "UnderwritingTerm";
	public static final String C_TRASYNDICATION_Edit = "Edit";

	// TrancheSyndication header
	public static final String C_TRASYNDICATIONHEADER_Add = "Add";
	public static final String C_TRASYNDICATIONHEADER_BussPartner = "BussPartner";
	public static final String C_TRASYNDICATIONHEADER_BussPartnerName = "BussPartnerName";
	public static final String C_TRASYNDICATIONHEADER_ParticipationVia = "ParticipationVia";
	public static final String C_TRASYNDICATIONHEADER_ValidFrom = "ValidFrom";
	public static final String C_TRASYNDICATIONHEADER_ValidTo = "ValidTo";
	public static final String C_TRASYNDICATIONHEADER_BankDetails = "BankDetails";
	public static final String C_TRASYNDICATIONHEADER_PaymentMethod = "PaymentMethod";
	public static final String C_TRASYNDICATIONHEADER_ParticipationType = "ParticipationType";

	// Tranche Syndication Participation
	public static final String C_TRASYNDICATIONPARTICIPATION_FinRatio = "FinanceRatio";
	public static final String C_TRASYNDICATIONPARTICIPATION_FinAmount = "FinanceAmount";
	public static final String C_TRASYNDICATIONPARTICIPATION_FinPptForm = "FinanceParticipationForm";
	public static final String C_TRASYNDICATIONPARTICIPATION_TraRatio = "TraRatio";
	public static final String C_TRASYNDICATIONPARTICIPATION_TraAmount = "TraAmount";
	public static final String C_TRASYNDICATIONPARTICIPATION_TraPptForm = "TraParticipationForm";
	public static final String C_TRASYNDICATIONPARTICIPATION_DraRatio = "DraRatio";
	public static final String C_TRASYNDICATIONPARTICIPATION_DraAmount = "DraAmount";
	public static final String C_TRASYNDICATIONPARTICIPATION_DraPptForm = "DraParticipationForm";
	public static final String C_TRASYNDICATIONPARTICIPATION_AddRatio = "AddRatio";

	// TranchePartners Sheet
	public static final String C_TRAPARTNERS_Edit = "Edit";
	public static final String C_TRAPARTNERS_Title = "Title";
	public static final String C_TRAPARTNERS_SelectBussPartner = "SelectBussPartner";
	public static final String C_TRAPARTNERS_PaymentMethod = "PaymentMethod";
	public static final String C_TRAPARTNERS_BankDetailsID = "BankDetailsID";
	public static final String C_TRAPARTNERS_MandateRef = "MandateRef";
	public static final String C_TRAPARTNERS_AddResponsibleAgent = "AddResponsibleAgent";
	public static final String C_TRAPARTNERS_AgentRole = "AgentRole";
	public static final String C_TRAPARTNERS_ResponsibleAgent = "ResponsibleAgent";
	public static final String C_TRAPARTNERS_OrgUnit = "OrgUnit";
	public static final String C_TRAPARTNERS_ValidFrom = "ValidFrom";
	public static final String C_TRAPARTNERS_UtilizationType = "UtilizationType";
	public static final String C_TRAPARTNERS_ClickSave = "ClickSave";
	public static final String C_TRAPARTNERS_CheckConsistency = "CheckConsistency";
	public static final String C_TRAPARTNERS_CheckConsistErrorMsg = "CheckConsistErrorMsg";
	public static final String C_TRAPARTNERS_ReCheckConsist = "ReCheckConsist";

	public static final String C_TRAPARTNERS_ReClickClose = "ReClickClose";
	public static final String C_TRAPARTNERS_ReleaseStatus = "ReleaseStatus";
	public static final String C_TRAPARTNERS_Syndication = "Syndication";
	public static final String C_TRAPARTNERS_DL = "DL";

	// Tranche Locks
	public static final String C_TraAddLock_Add = "AddLocks";
	public static final String C_TraAddLock_LockType = "LockType";
	public static final String C_TraAddLock_ValidFrom = "ValidFrom";
	public static final String C_TraAddLock_ValidTo = "ValidTo";
	public static final String C_TraAddLock_ExemptionAmount = "ExemptionAmount";

	// Tranche Payment Control Rule
	public static final String C_TraAddPaymentControlRule_Add = "AddPCRule";
	public static final String C_TraAddPaymentControlRule_Use = "Use";
	public static final String C_TraAddPaymentControlRule_ValidFrom = "ValidFrom";
	public static final String C_TraAddPaymentControlRule_ValidTo = "ValidTo";
	public static final String C_TraAddPaymentControlRule_PayerPayee = "PayerPayee";
	public static final String C_TraAddPaymentControlRule_PaymentMethod = "PaymentMethod";
	public static final String C_TraAddPaymentControlRule_BankDetails = "BankDetails";

	// Tranche Reference
	public static final String C_TraReferences_RefType = "Reference_Type";
	public static final String C_TraReferences_Identification = "Identification";
	public static final String C_TraReferences_URL = "URL";
	public static final String C_TraReferences_Name = "Name";
	public static final String C_TraReferences_From = "From";
	public static final String C_TraReferences_To = "To";

	// Tranche Overview
	public static final String C_TRANCHEOVERVIEW_APPLY = "ClickApply";

	// Create Drawdown Sheet
	public static final String C_CREATEDRAWDOWN_DDName = "DDName";
	public static final String C_CREATEDRAWDOWN_MainBorrower = "MainBorrower";
	public static final String C_CREATEDRAWDOWN_DDProduct = "DDProduct";
	public static final String C_CREATEDRAWDOWN_DDAmt = "DDAmt";
	public static final String C_CREATEDRAWDOWN_DDCurr = "DDCurr";
	public static final String C_CREATEDRAWDOWN_Disbrate = "Disbrate";
	public static final String C_CREATEDRAWDOWN_StartofTerm = "StartofTerm";
	public static final String C_CREATEDRAWDOWN_EndofTerm = "EndofTerm";
	public static final String C_CREATEDRAWDOWN_EndDate = "EndDate";
	public static final String C_CREATEDRAWDOWN_FTR_FLAG = "FTR_FLAG";
	public static final String C_CREATEDRAWDOWN_ClickCreateEdit = "ClickCreateEdit";

	// Edit Drawdown Conditions
	public static final String C_DRACONDITIONSHEADER_ConditionType = "ConditionType";
	public static final String C_DRACONDITIONSHEADER_PeriodicProfile = "PeriodicProfile";
	public static final String C_DRACONDITIONSHEADER_CalculationDate = "CalculationDate";
	public static final String C_DRACONDITIONSHEADER_DueDate = "DueDate";
	public static final String C_DRACONDITIONSHEADER_ValidFrom="ValidFrom";
	public static final String C_DRACONDITIONSHEADER_Percentage="Percentage";
	public static final String C_DRACONDITIONSHEADER_Amount="Amount";
	public static final String C_DRACONDITIONSHEADER_Payer="Payer";
	public static final String C_DRACONDITIONSHEADER_EditCondition = "EditCondition";
	public static final String C_DRACONDITIONSHEADER_AddCondition = "AddCondition";
	public static final String C_DRACONDITIONSHEADER_IM="InterestMethod";
	public static final String C_DRACONDITIONSHEADER_Effective_IntrstMethod="Effective_IntrstMethod";
	public static final String C_DRACONDITIONSHEADER_Discount_withholding="Discount_withholding";
	public static final String C_DRACONDITIONSHEADER_Effective_Interest="Effective_Interest";
	public static final String C_DRACONDITIONSHEADER_Remove = "RemoveConditions";
	public static final String C_DRACONDITIONSHEADER_OtherFee="OtherFee";
	public static final String C_DRACONDITIONSHEADER_FixedRate="FixedRate";

	//Conditions Dates
	public static final String C_DRACONDITIONSDATES_FactoryCaledar="FactoryCaledar";
	public static final String C_DRACONDITIONSDATES_CD_Type="CD_Type";
	public static final String C_DRACONDITIONSDATES_CD_Frequency="CD_Frequency";
	public static final String C_DRACONDITIONSDATES_CD_FreqType="CD_FreqType";
	public static final String C_DRACONDITIONSDATES_CD_Date="CD_Date";
	public static final String C_DRACONDITIONSDATES_CD_MonthEnd="CD_MonthEnd";
	public static final String C_DRACONDITIONSDATES_CD_Including="CD_Including";
	public static final String C_DRACONDITIONSDATES_CD_CalRule="CD_CalRule";
	public static final String C_DRACONDITIONSDATES_CD_Shift="CD_Shift";
	public static final String C_DRACONDITIONSDATES_CD_ShiftVal="CD_ShiftVal";
	public static final String C_DRACONDITIONSDATES_DD_Type="DD_Type";
	public static final String C_DRACONDITIONSDATES_DD_Date="DD_Date";
	public static final String C_DRACONDITIONSDATES_DD_MonthEnd="DD_MonthEnd";
	public static final String C_DRACONDITIONSDATES_DD_Including="DD_Including";
	public static final String C_DRACONDITIONSDATES_DD_CalRule="DD_CalRule";
	public static final String C_DRACONDITIONSDATES_DD_Shift="DD_Shift";
	public static final String C_DRACONDITIONSDATES_DD_ShiftVal="DD_ShiftVal";
	public static final String C_DRACONDITIONSDATES_PD_WorkingDay="PD_WorkingDay";
	public static final String C_DRACONDITIONSDATES_OCD_ShiftDD="OCD_ShiftDD";
	public static final String C_DRACONDITIONSDATES_OCD_DDR="OCD_DDR";
	public static final String C_DRACONDITIONSDATES_Create="Create";

	// TranchePartners Sheet
	public static final String C_DRAPARTNERS_Edit = "Edit";
	public static final String C_DRAPARTNERS_Title = "Title";
	public static final String C_DRAPARTNERS_SelectBussPartner = "SelectBussPartner";
	public static final String C_DRAPARTNERS_PaymentMethod = "PaymentMethod";
	public static final String C_DRAPARTNERS_BankDetailsID = "BankDetailsID";
	public static final String C_DRAPARTNERS_MandateRef = "MandateRef";
	public static final String C_DRAPARTNERS_AddResponsibleAgent = "AddResponsibleAgent";
	public static final String C_DRAPARTNERS_AgentRole = "AgentRole";
	public static final String C_DRAPARTNERS_ResponsibleAgent = "ResponsibleAgent";
	public static final String C_DRAPARTNERS_OrgUnit = "OrgUnit";
	public static final String C_DRAPARTNERS_ValidFrom = "ValidFrom";
	public static final String C_DRAPARTNERS_UtilizationType = "UtilizationType";
	public static final String C_DRAPARTNERS_ClickApply = "ClickApply";
	public static final String C_DRAPARTNERS_CheckConsistency = "CheckConsistency";
	public static final String C_DRAPARTNERS_CheckConsistErrorMsg = "CheckConsistErrorMsg";
	public static final String C_DRAPARTNERS_ReCheckConsist = "ReCheckConsist";
	public static final String C_DRAPARTNERS_ReClickClose = "ReClickClose";
	public static final String C_DRAPARTNERS_ReleaseStatus = "ReleaseStatus";
	public static final String C_DRAPARTNERS_Syndication = "Syndication";

	// Overview
	public static final String C_OVERVIEW_SAVE = "ClickSave";
	public static final String C_OVERVIEW_ReleaseStatus = "ReleaseStatus";
	public static final String C_OVERVIEW_ClickSubmit="ClickSubmit";
	public static final String C_OVERVIEW_SubmittedStatus = "SubmittedStatus";

	// CreateDrawDown Sheet
	public static final String C_CREATEDRAWDOWN_CheckNewDrawDown = "CheckNewDrawDown";
	public static final String C_CREATEDRAWDOWN_DrawDownProduct = "DrawDownProduct";
	public static final String C_CREATEDRAWDOWN_DrawDownName = "DrawDownName";

	// Drawdown Covenants
	public static final String C_DRACOVENANTS_Add = "AddCovenants";

	// Drawdown Covenants Header
	public static final String C_DRACOVENANTSHEADER_TYPE = "CovenantType";
	public static final String C_DRACOVENANTSHEADER_Description = "Description";
	public static final String C_DRACOVENANTSHEADER_EOC_Consequences = "EOC_Consequences";
	public static final String C_DRACOVENANTSHEADER_ValidFrom = "ValidFrom";
	public static final String C_DRACOVENANTSHEADER_ValidTo = "ValidTo";
	public static final String C_DRACOVENANTSHEADER_Date = "Date";

	// Drawdown Covenants Details
	public static final String C_DRACOVENANTSDETAILS_ResultSupplier = "ResultSupplier";
	public static final String C_DRACOVENANTSDETAILS_CheckProcedure = "CheckProcedure";
	public static final String C_DRACOVENANTSDETAILS_SoftThreshold = "SoftThreshold";
	public static final String C_DRACOVENANTSDETAILS_HardThreshold = "HardThreshold";
	public static final String C_DRACOVENANTSDETAILS_FirstKeyDate = "FirstKeyDate";
	public static final String C_DRACOVENANTSDETAILS_MonitoringProcedure = "MonitoringProcedure";
	public static final String C_DRACOVENANTSDETAILS_CalculationPeriod = "CalculationPeriod";
	public static final String C_DRACOVENANTSDETAILS_PeriodType1 = "PeriodType1";
	public static final String C_DRACOVENANTSDETAILS_SubmissionDeadline = "SubmissionDeadline";
	public static final String C_DRACOVENANTSDETAILS_PeriodType2 = "PeriodType2";

	// Drawdown CovenantsCC
	public static final String C_DRACOVENANTSCC_Add = "AddCC";

	// Drawdown CovenantsCC Add Lock
	public static final String C_DRACOVENANTSCCADDLOCK_Type = "Type";
	public static final String C_DRACOVENANTSCCADDLOCK_Usage = "Usage";
	public static final String C_DRACOVENANTSCCADDLOCK_ObligatoryConsequence = "ObligatoryConsequence";
	public static final String C_DRACOVENANTSCCADDLOCK_LockType = "LockType";
	public static final String C_DRACOVENANTSCCADDLOCK_IndividualLock = "IndividualLock";
	public static final String C_DRACOVENANTSCCADDLOCK_CollectiveLock = "CollectiveLock";
	public static final String C_DRACOVENANTSCCADDLOCK_ValidFrom = "ValidFrom";
	public static final String C_DRACOVENANTSCCADDLOCK_Term = "Term";
	public static final String C_DRACOVENANTSCCADDLOCK_ICA_FLAG = "ICA_FLAG";
	public static final String C_DRACOVENANTSCCADDLOCK_CreateCovenant = "CreateCovenant";

	// Drawdown Syndication
	public static final String C_DRASYNDICATION_Title = "Title";
	public static final String C_DRASYNDICATION_Role = "Role";
	public static final String C_DRASYNDICATION_MandatorySyndication = "MandatorySyndication";
	public static final String C_DRASYNDICATION_Value = "Value";
	public static final String C_DRASYNDICATION_UnderwritingTerm = "UnderwritingTerm";
	public static final String C_DRASYNDICATION_Edit = "Edit";

	// Drawdown Syndication header
	public static final String C_DRASYNDICATIONHEADER_Add = "Add";
	public static final String C_DRASYNDICATIONHEADER_BussPartner = "BussPartner";
	public static final String C_DRASYNDICATIONHEADER_BussPartnerName = "BussPartnerName";
	public static final String C_DRASYNDICATIONHEADER_ParticipationVia = "ParticipationVia";
	public static final String C_DRASYNDICATIONHEADER_ValidFrom = "ValidFrom";
	public static final String C_DRASYNDICATIONHEADER_ValidTo = "ValidTo";
	public static final String C_DRASYNDICATIONHEADER_BankDetails = "BankDetails";
	public static final String C_DRASYNDICATIONHEADER_PaymentMethod = "PaymentMethod";
	public static final String C_DRASYNDICATIONHEADER_ParticipationType = "ParticipationType";


	// Drawdown Syndication Participation
	public static final String C_DRASYNDICATIONPARTICIPATION_FinRatio = "FinanceRatio";
	public static final String C_DRASYNDICATIONPARTICIPATION_FinAmount = "FinanceAmount";
	public static final String C_DRASYNDICATIONPARTICIPATION_FinPptForm = "FinanceParticipationForm";
	public static final String C_DRASYNDICATIONPARTICIPATION_TraRatio = "TraRatio";
	public static final String C_DRASYNDICATIONPARTICIPATION_TraAmount = "TraAmount";
	public static final String C_DRASYNDICATIONPARTICIPATION_TraPptForm = "TraParticipationForm";
	public static final String C_DRASYNDICATIONPARTICIPATION_DraRatio = "DraRatio";
	public static final String C_DRASYNDICATIONPARTICIPATION_DraAmount = "DraAmount";
	public static final String C_DRASYNDICATIONPARTICIPATION_DraPptForm = "DraParticipationForm";
	public static final String C_DRASYNDICATIONPARTICIPATION_AddRatio = "AddRatio";

	// Drawdown Locks
	public static final String C_DRALOCKS_Add = "AddLocks";
	public static final String C_DRALOCKS_LockType = "LockType";
	public static final String C_DRALOCKS_ValidFrom = "ValidFrom";
	public static final String C_DRALOCKS_ValidTo = "ValidTo";
	public static final String C_DRALOCKS_ExemptionAmount = "ExemptionAmount";

	// Drawdown Payment Control Rule
	public static final String C_DRAPCRULE_Add = "AddPCRule";
	public static final String C_DRAPCRULE_Use = "Use";
	public static final String C_DRAPCRULE_ValidFrom = "ValidFrom";
	public static final String C_DRAPCRULE_ValidTo = "ValidTo";
	public static final String C_DRAPCRULE_PayerPayee = "PayerPayee";
	public static final String C_DRAPCRULE_PaymentMethod = "PaymentMethod";
	public static final String C_DRAPCRULE_BankDetails = "BankDetails";

	// Drawdown Reference
	public static final String C_DraReferences_RefType = "Reference_Type";
	public static final String C_DraReferences_Identification = "Identification";
	public static final String C_DraReferences_URL = "URL";
	public static final String C_DraReferences_Name = "Name";
	public static final String C_DraReferences_From = "From";
	public static final String C_DraReferences_To = "To";

	// Show Cash Flow
	public static final String C_SCF_PAGETITLE = "PageTitle";
	public static final String C_SCF_TYPE="Type";
	public static final String C_SCF_RECORD="Record";

	// My Inbox
	public static final String C_MYINBOX_SearchName = "SearchName";
	public static final String C_MYINBOX_Type= "Type";
	public static final String C_MYINBOX_Action = "Action";

	// My Inbox reject
	public static final String C_MyInboxReject_SearchName = "SearchName";
	public static final String C_MyInboxReject_Type= "Type";
	public static final String C_MyInboxReject_Action = "Action";
	public static final String C_MyInboxReject_Details = "Details";

	//Title
	public static final String PageFinance = "Financing"; 

	//Business Operations
	public static final String C_BO_ID="ID";
	public static final String C_BO_InitialStatus="InitialStatus";
	public static final String C_BO_FinalStatus="FinalStatus";
	public static final String C_BO_Deletion="Deletion";
	public static final String C_BO_Type="BOType";

	//Copy
	public static final String C_COPY_SHOWLEVEL="Level";
	public static final String C_COPY_ET_BusinessPartners="ET_BusinessPartners";
	public static final String C_COPY_ET_ResponsibleAgents="ET_ResponsibleAgents";
	public static final String C_COPY_ET_SyndicationAgreements="ET_SyndicationAgreements";
	public static final String C_COPY_ET_Locks="ET_Locks";
	public static final String C_COPY_ET_PaymentControlRules="ET_PaymentControlRules";
	public static final String C_COPY_ET_Conditions="ET_Conditions";
	public static final String C_COPY_ET_DrawdownRules="ET_DrawdownRules";
	public static final String C_COPY_ET_Covenants="ET_Covenants";
	public static final String C_COPY_CopyText="CopyText";
	public static final String C_COPY_DealID="DealID";

	// AddBorrowers Sheet

	public static final String C_AddBorrowers_PermBorrowers = "PermBorrowers";
	public static final String C_AddBorrowers_MainBorrower = "MainBorrower";
	public static final String C_AddBorrowers_BorrowerName = "BorrowerName";
	public static final String C_AddBorrowers_ValidFrom = "ValidFrom";
	public static final String C_AddBorrowers_ValidTo = "ValidTo";

	// New Reduction Sheet
	public static final String C_NewReduction_Title = "Title";
	public static final String C_NewReduction_ReductionAmount = "ReductionAmount";
	public static final String C_NewReduction_Save = "Save";
	public static final String C_NewReduction_Submit = "Submit";

	// Borrower Change Sheet
	public static final String C_BOChange_Title = "Title";
	public static final String C_BOChange_MainBorrower = "MainBorrower";
	public static final String C_BOChange_BorrowerName = "BorrowerName";
	public static final String C_BOChange_TransferDate = "TransferDate";
	public static final String C_BOChange_Reason = "Reason";
	public static final String C_BOChange_PaymentMethod = "PaymentMethod";
	public static final String C_BOChange_BankDetails = "BankDetails";
	public static final String C_BOChange_AlternativePayer = "Payer";
	public static final String C_BOChange_AuthorizedDrawer = "Drawer";
	public static final String C_BOChange_AttachCharge = "AttachCharge";
	public static final String C_BOChange_ToAccount = "ToAccount";
	public static final String C_BOChange_ChargeAmount = "ChargeAmount";
	public static final String C_BOChange_DueDate = "DueDate";
	public static final String C_BOChange_Flowtype = "Flowtype";
	public static final String C_BOChange_Save = "Save";
	public static final String C_BOChange_Submit = "Submit";

	//Consolidate Drawdown
	public static final String C_ConsolidateDD_Title="Title";			
	public static final String C_ConsolidateDD_BOText="BOText";
	public static final String C_ConsolidateDD_TargetDrawdown="TargetDrawdown";
	public static final String C_ConsolidateDD_TransferDate="TransferDate";
	public static final String C_ConsolidateDD_MonthEnd="MonthEnd";
	public static final String C_ConsolidateDD_InterestCalculation="InterestCalculation";
	public static final String C_ConsolidateDD_CapitalTransferReason="CapitalTransferReason";
	public static final String C_ConsolidateDD_TransferOpenItems="TransferOpenItems";
	public static final String C_ConsolidateDD_CITarget="CITarget";
	public static final String C_ConsolidateDD_TransferAmount="TransferAmount";
	public static final String C_ConsolidateDD_Quota="Quota";

	//Split Drawdown
	public static final String C_SplitDD_Title="Title";			
	public static final String C_SplitDD_SourceDD="SourceDD";
	public static final String C_SplitDD_TransferDate="TransferDate";
	public static final String C_SplitDD_IC_Option="IC_Option";
	public static final String C_SplitDD_Source="Source";
	public static final String C_SplitDD_Target="Target";
	public static final String C_SplitDD_Reason="Reason";
	public static final String C_SplitDD_AddDD="AddDD";
	public static final String C_SplitDD_Name="Name";
	public static final String C_SplitDD_TransferAmount="Amount";
	public static final String C_SplitDD_Quota="Quota";
	public static final String C_SplitDD_PaymentMethod="PaymentMethod";
	public static final String C_SplitDD_BankDetails="BankDetails";
	public static final String C_SplitDD_MandateReferece="MandateReferece";
	public static final String C_SplitDD_NewMainBorrower="NewMainBorrower";
	public static final String C_SplitDD_AP="AlternatePayer";
	public static final String C_SplitDD_Submit="Submit";

	// Condition Payment
	public static final String C_CONDITIONSPAYMENT_BankDetails = "BankDetails";
	public static final String C_CONDITIONSPAYMENT_PaymentMethod = "PaymentMethod";
	public static final String C_CONDITIONSPAYMENT_PaymentBlock = "PaymentBlock";
	public static final String C_CONDITIONSPAYMENT_DunningArea = "DunningArea";
	public static final String C_CONDITIONSPAYMENT_DunningBlock = "DunningBlock";
	public static final String C_CONDITIONSPAYMENT_Apply = "Apply";
	public static final String C_CONDITIONSPAYMENT_Payer = "Payer";

	// Borrower Change Sheet
	public static final String C_UFT_CC = "CompanyCode";
	public static final String C_UFT_ACN = "Account_Number";
	public static final String C_UFT_Date = "Date";
	public static final String C_UFT_Posted = "Posted";		

	// Payoff Sheet
	public static final String C_Payoff_PostingType = "PostingType";
	public static final String C_Payoff_PayoffType = "PayoffType";
	public static final String C_Payoff_DueOn = "DueOn";
	public static final String C_Payoff_RepaymentChange = "RepaymentChange";	
	public static final String C_Payoff_NetPayoffAmount = "NetPayoffAmount";
	public static final String C_Payoff_PaymentMethod = "PaymentMethod";	
	
	// New Deferral Sheet
		public static final String C_Deferral_Title = "Title";
		public static final String C_Deferral_PostingType = "PostingType";
		public static final String C_Deferral_KeyDate = "KeyDate";
		public static final String C_Deferral_PaymentDate = "PaymentDate";
		public static final String C_Deferral_PostPrcsng = "PostPrcsng";
		public static final String C_Deferral_Reason = "Reason";
		public static final String C_Deferral_PrcsCharge = "PrcsCharge";
		public static final String C_Deferral_FirstInstl = "FirstInstl";
		public static final String C_Deferral_NoOfInstl = "NoOfInstl";
		public static final String C_Deferral_Save = "Save";
		public static final String C_Deferral_Submit = "Submit";
		public static final String C_Deferral_Deletion="Deletion";
		
		// New WriteOff Sheet
			public static final String C_WriteOff_Title = "Title";
			public static final String C_WriteOff_PostingType = "PostingType";
			public static final String C_WriteOff_PaymentDate = "PaymentDate";
			public static final String C_WriteOff_Amount = "Amount";
			public static final String C_WriteOff_BOText = "BOText";
			public static final String C_WriteOff_Edit = "Edit";
			public static final String C_WriteOff_Apply = "Apply";
			public static final String C_WriteOff_Submit = "Submit";
			public static final String C_WriteOff_Deletion="Deletion";
			
			// New ShareSellP Sheet
			public static final String C_ShareSellP_Title = "Title";
			public static final String C_ShareSellP_Buyer = "Buyer";
			public static final String C_ShareSellP_TransferDate = "TransferDate";
			public static final String C_ShareSellP_ConditionType = "ConditionType";
			public static final String C_ShareSellP_AccNum = "AccNum";
			public static final String C_ShareSellP_Reason = "Reason";
			public static final String C_ShareSellP_Amount = "Amount";
			public static final String C_ShareSellP_BOText = "BOText";
			public static final String C_ShareSellP_AttachCharge = "AttachCharge";
			public static final String C_ShareSellP_Save = "Save";
			public static final String C_ShareSellP_Submit = "Submit";
			public static final String C_ShareSellP_Deletion="Deletion";
		
					
			// New ShareSellA Sheet	
			public static final String C_ShareSellA_Title = "Title";
			public static final String C_ShareSellA_Buyer = "Buyer";
			public static final String C_ShareSellA_TransferDate = "TransferDate";
			public static final String C_ShareSellA_PaymentMethod = "PaymentMethod";
			public static final String C_ShareSellA_PaymentMethod1 = "PaymentMethod1";
			public static final String C_ShareSellA_BankDetails = "BankDetails";
			public static final String C_ShareSellA_ConditionType = "ConditionType";
			public static final String C_ShareSellA_AccNum = "AccNum";
			public static final String C_ShareSellA_TransferAmount = "TransferAmount";
			public static final String C_ShareSellA_BuyerAmount = "BuyerAmount";
			public static final String C_ShareSellA_BOText = "BOText";
			public static final String C_ShareSellA_AttachCharge = "AttachCharge";
			public static final String C_ShareSellA_Payee = "Payee";
			public static final String C_ShareSellA_Save = "Save";
			public static final String C_ShareSellA_Submit = "Submit";
			public static final String C_ShareSellA_Deletion="Deletion";
			
			// New SharePurchase Sheet
			public static final String C_SharePurchase_Title = "Title";
			public static final String C_SharePurchase_TransferDate = "TransferDate";
			public static final String C_SharePurchase_Reason = "Reason";
			public static final String C_SharePurchase_BOText = "BOText";
			public static final String C_SharePurchase_AccNum = "AccNum";
			public static final String C_SharePurchase_Amount = "Amount";
			public static final String C_SharePurchase_AttachCharge = "AttachCharge";
			public static final String C_SharePurchase_Save = "Save";
			public static final String C_SharePurchase_Submit = "Submit";
			public static final String C_SharePurchase_Deletion="Deletion";
			
			// New ShareSwap Sheet
			public static final String C_ShareSwap_Title = "Title";
			public static final String C_ShareSwap_TransferDate = "TransferDate";
			public static final String C_ShareSwap_Payer = "Payer";
			public static final String C_ShareSwap_AccNum = "AccNum";
			public static final String C_ShareSwap_Synmem = "SyndicateMember";
			public static final String C_ShareSwap_Amount = "Amount";
			public static final String C_ShareSwap_BOText = "BOText";
			public static final String C_ShareSwap_AttachCharge = "AttachCharge";
			public static final String C_ShareSwap_Save = "Save";
			public static final String C_ShareSwap_Submit = "Submit";
			public static final String C_ShareSwap_Deletion="Deletion";
			
			//Validate Amount
			
			public static final String C_ValidateAmount_Level = "Level";
			public static final String C_ValidateAmount_Name = "Name";
			public static final String C_ValidateAmount_FinUtil= "FinUtil";
			public static final String C_ValidateAmount_TraUtil= "TraUtil";	
			public static final String C_ValidateAmount_FinOpenLoC= "FinOpenLoC";
			public static final String C_ValidateAmount_TraOpenLoC= "TraOpenLoC";
			public static final String C_ValidateAmount_SynMemOpenLoC= "SynMemOpenLoC";
			
			//Edit Rules
			public static final String C_PCRULE_EditConditions="EditConditions";
			public static final String C_PCRULE_EditPayOff="EditPayOff";
			public static final String C_PCRULE_EditDisbursement="EditDisbursement";
			public static final String C_PCRULE_ConditionPayment="ConditionPayment";
			public static final String C_PCRULE_PayOffPayment="PayOffPayment";
			public static final String C_PCRULE_DisbPayment="DisbPayment";
			public static final String C_PCRULE_BankDtls="BankDetailsID";
			public static final String C_PCRULE_MDRef="MDRef";
			public static final String C_PCRULE_EditCCR="EditCCR";
			public static final String C_PCRULE_CorrLang="CorrLang";
			public static final String C_PCRULE_AddressID="AddressID";
			public static final String C_PCRULE_DspMethod="DspMethod";
			public static final String C_PCRULE_Overwrite="Overwrite";
			public static final String C_PCRULE_Original="Original";
			//public static final String C_PCRULE_BankDetailsID="BankDetailsID";
				

	// Toast Messages
	public static final String bankdtlsUpdatemsg = "The object has been updated";
	public static final String AddresponsibleAgentmsg = "The object has been added";
	public static final String AddLockmsg = "The object has been added";
	public static final String AddPMCmsg = "The object has been added";
	public static final String saveFinancemsg = "Financing saved";
	public static final String newtranceMsg = "New tranche created";
	public static final String newDDMsg = "New drawdown created";
	public static final String submitFinancemsg = "Working version submitted";
	public static final String Disbcreationmsg = "Disbursement created";
	public static final String Disbdeletionmsg = "Disbursement deleted ";
	public static final String Disbsentapproval = "Disbursement sent for approval";
	public static final String CopyFinance="The financing has been copied";
	public static final String submitRenewal="Renewal is saved and submitted";
	public static final String submitWithdrawal="Withdrawal has been submitted";
	public static final String approveMail="Approved";
	public static final String submitBOmsg = "Borrower change has been saved and sent for approval";
	public static final String submitReductionmsg = "Reduction has been submitted";








}